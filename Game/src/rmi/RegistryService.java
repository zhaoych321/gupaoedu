package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryService {
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(9999);
		HelloRegistryFacadeImpl hello = new HelloRegistryFacadeImpl();
//		Naming.bind("rmi://localhost:8888/HelloRegistry", hello);
		registry.rebind("HelloRegistry", hello);
		System.out.println("====启动RMI服务成功！====");
	}
}
