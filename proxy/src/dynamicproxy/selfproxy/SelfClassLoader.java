package dynamicproxy.selfproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class SelfClassLoader extends ClassLoader {

    private File classFilePath;

    public SelfClassLoader() {
        String path = SelfClassLoader.class.getResource("").getPath();
        classFilePath = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = SelfClassLoader.class.getPackage().getName() + "." + name;
        if ( null != classFilePath ) {
            File fileCLass = new File(classFilePath, name.replaceAll("\\.","/") + ".class");
            if (fileCLass.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(fileCLass);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
