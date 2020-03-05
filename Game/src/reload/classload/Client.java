package reload.classload;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Client {
	public static void main(String[] args) throws IOException {
//		Server server = new Server();
//		server.init();
//		int i=0;
//		while(true){
//			i++;
//			String name="name"+i;
//			String result=server.doWork(name);
//			System.out.println(result);
//			try {
//				Thread.sleep(1000* 5);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}	
//		}
		
		JarFile jarFile = new JarFile("gsxdb.jar");
		Enumeration<JarEntry> enumeration = jarFile.entries();
		while(enumeration.hasMoreElements()){
			JarEntry entry = enumeration.nextElement();
			String name = entry.getName();
			if(!name.endsWith(".class")){
				continue;
			}
			System.out.println(name);
		}
//		File file = new File("Box.java");
//		System.out.println(file.getAbsolutePath());
	}
}
