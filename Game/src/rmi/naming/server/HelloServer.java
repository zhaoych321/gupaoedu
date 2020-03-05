package rmi.naming.server;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import rmi.naming.HelloImpl;

public class HelloServer {
	public static void main(String args[]) {
        try {
        	// 本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099）
            LocateRegistry.createRegistry(8888);
            // 把远程对象注册到RMI注册服务器上，并命名为RHello
            // 绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的）
            Remote remote = UnicastRemoteObject.exportObject(new HelloImpl(), 8888);
//            Remote remote = new HelloImpl();
            Naming.bind("rmi://localhost:8888/RHello", remote);
            // Naming.bind("//localhost:8888/RHello",rhello);
            System.out.println("------------远程对象IHello注册成功，等待客户端调用...");
            while(true) {
            	Thread.sleep(10000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
