package rmi.naming;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote {
	/**
     * 更新user信息
     * @param user
     * @return
     * @throws RemoteException
     */
    public User updateUser(User user) throws RemoteException;
}
