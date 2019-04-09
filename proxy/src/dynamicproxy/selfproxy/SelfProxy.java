package dynamicproxy.selfproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;


public class SelfProxy {

    public static Object newProxyInstance(SelfClassLoader loader,
                                          Class<?>[] interfaces,
                                          SelfInvocationHandler h)
            throws IllegalArgumentException
    {
        try {
            String str = genStr(interfaces);
//            System.out.println(str);

            String path = SelfProxy.class.getResource("").getPath();
            File file = new File(path + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(str);
            fw.flush();
            fw.close();

            JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = jc.getStandardFileManager(null, null, null);
            Iterable it = manager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask ct = jc.getTask(null, manager, null, null, null, it);
            ct.call();
            manager.close();

            //4、编译生成的.class文件加载到JVM中来
            Class proxyClass =  loader.findClass("$Proxy0");
            java.lang.reflect.Constructor c = proxyClass.getConstructor(SelfInvocationHandler.class);
            file.delete();

            //5、返回字节码重组以后的新的代理对象
            return c.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static final String ln = "\r\n";

    public static String genStr(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package dynamicproxy.selfproxy;" + ln);
        sb.append("import staticproxy.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("SelfInvocationHandler h;" + ln);
        sb.append("public $Proxy0(SelfInvocationHandler h) { " + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);
        for (Method m : interfaces[0].getMethods()){
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " +  paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if(i > 0 && i < params.length-1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }
        sb.append("}" + ln);
        return sb.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() +  ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
