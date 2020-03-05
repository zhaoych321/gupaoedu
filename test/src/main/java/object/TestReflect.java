package object;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflect {
    public static void main(String[] args) {
        try {
            /********Class***********/
            String str = "abc";
            Class cls1 = str.getClass();
            Class cls2 = String.class;
            Class cls3 = null;
            cls3 = Class.forName("java.lang.String");

            System.out.println(cls1 == cls2);
            System.out.println(cls1 == cls3);

            System.out.println(cls1.isPrimitive());
            System.out.println(int.class.isPrimitive());
            System.out.println(int.class == Integer.class);
            System.out.println(int.class == Integer.TYPE);
            System.out.println(int[].class.isPrimitive());
            System.out.println(int[].class.isArray());

            //        String str1 = "abc";
            System.out.println(String.class.getConstructor(StringBuffer.class));

            System.out.println(ReflectPointer.class.getConstructor(int.class, int.class));
            System.out.println(Class.forName("object.ReflectPointer").getConstructor(Integer.TYPE, Integer.TYPE));


            /**************Filed***************/
            Constructor<ReflectPointer> constructor = ReflectPointer.class.getConstructor(int.class, int.class);
            ReflectPointer r = constructor.newInstance(3, 4);
            Field fieldX = r.getClass().getField("x");
            System.out.println(fieldX.get(r));

            Field fieldY = r.getClass().getDeclaredField("y");
            fieldY.setAccessible(true);
            System.out.println(fieldY.get(r));

            ReflectPointer rp1 = new ReflectPointer(3, 4);
            changeBtoA(rp1);
            System.out.println(rp1);

            Method m = Class.forName("object.Inter").getMethod("main", String[].class);

            m.invoke(null, new Object[]{new java.lang.String[]{"111", "222", "333"}});
            m.invoke(null, (Object) new String[]{"111", "222", "333"});

            /*******Method********/
            String  s = "shfsfs";
            Method charAt = String.class.getMethod("charAt", int.class);
            Object invoke = charAt.invoke(s, 1);
            System.out.println(invoke);

            System.out.println(charAt.invoke(s, new Object[]{2}));

            /***********数组的反射*****************/
            int[] a = new int[3];
            int[] b = {4, 5, 5}; //直接赋值后不可以指定长度，否则ＣＥ
            int[][] c = new int[3][2];
            String[] d = {"jjj", "kkkk"};
            System.out.println(a == b); //false
            System.out.println(a.getClass() == b.getClass()); //true
//            System.out.println(a.getClass() == d.getClass());    //比较字节码a和cd也没法比
            System.out.println(a.getClass());
            System.out.println(a.getClass().getName());

            System.out.println(a.getClass().getSuperclass());
            System.out.println(d.getClass().getSuperclass());

            Object obj1 = a;
            Object obj2 = b;
            Object[] objet3 = c;
            Object object4 = d;

            System.out.println(Arrays.asList(b));
            System.out.println(Arrays.asList(d));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeBtoA(Object obj) {
        try {

            Field[] fields = obj.getClass().getFields();
            for (Field field: fields) {
                if (field.getType() == String.class) {
                    String o = (String)field.get(obj);
                    String n = o.replace('b', 'a');
                    field.set(obj, n);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
