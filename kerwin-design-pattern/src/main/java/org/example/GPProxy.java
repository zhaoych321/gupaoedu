package org.example;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GPProxy {
    public static final String ln = "\r\n";
    public static Object newProxyInstance(GPClassLoader classLoader, Class<?> [] interfaces, GPInvocationHandler h){
        try {
//动态生成源代码.java 文件
            String src = generateSrc(interfaces);
//Java 文件输出磁盘
            String filePath = GPProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
//把生成的.java 文件编译成.class 文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manage.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null, iterable);
            task.call();
            manage.close();
//把编译生成的.class 文件加载到 JVM 中
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            f.delete();
//返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static String generateSrc(Class<?>[] interfaces){

        StringBuffer sb = new StringBuffer();
        sb.append("package org.example;" + ln);
        sb.append("import org.example.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("\tGPInvocationHandler h;" + ln);
        sb.append("\tpublic $Proxy0(GPInvocationHandler h) { " + ln);
        sb.append("\t\tthis.h = h;" + ln);
        sb.append("\t}" + ln);
        for (Method m : interfaces[0].getMethods()){
            int count = 0;
            Class<?>[] params = m.getParameterTypes();
            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();
            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = "m" + count;
                count ++;
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if(i > 0 && i < params.length-1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }
            sb.append("\tpublic " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString()
                    + ") {" + ln);
            sb.append("\t\ttry{" + ln);
            sb.append("\t\t\tMethod m = " + interfaces[0].getName() + ".class.getMethod (\"" + m.getName() +
                    "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            if(m.getReturnType() != void.class){
                sb.append("\t\t\treturn ");
                sb.append("(" + m.getReturnType().getName() + ")");
                sb.append("(this.h.invoke(this,m,new Object[]{" + paramValues + "}));").append(ln);
            }else{
                sb.append("\t\t\tthis.h.invoke(this,m,new Object[]{" + paramValues + "});").append(ln);
            }
            sb.append("\t\t}catch(Error _ex) { }" + ln);
            sb.append("\t\tcatch(Throwable e){" + ln);
            sb.append("\t\t\tthrow new UndeclaredThrowableException(e);" + ln);
            sb.append("\t\t}"+ ln);
            if(mappings.containsKey(m.getReturnType())){
                sb.append("\t\treturn 0;" + ln);
            }else if(m.getReturnType() == void.class){
            }else {
                sb.append("\t\treturn null;" + ln);
            }
            sb.append("\t}" + ln);
        }
        sb.append("}" + ln);
        return sb.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
        mappings.put(byte.class,Byte.class);
        mappings.put(short.class,Short.class);
        mappings.put(double.class,Double.class);
        mappings.put(float.class,Float.class);
    }
}
