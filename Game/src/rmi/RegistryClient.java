package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryClient {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry(9999);
			HelloRegistryFacade hello = (HelloRegistryFacade)registry.lookup("HelloRegistry");
			String response = hello.helloWorld("zhanjie");
			System.out.println("====="+response+"====");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
