package rmi;

import java.rmi.RemoteException;

public class HelloRegistryFacadeImpl implements HelloRegistryFacade{

	@Override
	public String helloWorld(String name) throws RemoteException {
		return "[Registry]你好！" + name;
	}

}
