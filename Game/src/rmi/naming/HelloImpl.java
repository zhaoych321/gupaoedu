package rmi.naming;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//public class HelloImpl extends UnicastRemoteObject implements IHello {
//
//	 /**
//     * 
//     */
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，必须声明抛出RemoteException异常
//     * 
//     * @throws RemoteException
//     */
//    public HelloImpl() throws RemoteException {
//    }
//
//    public User updateUser(User user) throws RemoteException {
//        System.out.println("-------------- 客户端发送的user为" + user.toString());
//        user.setName("andy2");
//        user.setAge(30);
//        return user;
//    }
//
//}

public class HelloImpl implements IHello {

   public HelloImpl() throws RemoteException {
   }

   public User updateUser(User user) throws RemoteException {
       System.out.println("-------------- 客户端发送的user为" + user.toString());
       user.setName("andy2");
       user.setAge(30);
       return user;
   }
}
