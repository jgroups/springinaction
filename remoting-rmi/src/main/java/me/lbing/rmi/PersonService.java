package me.lbing.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by King on 2016/6/3.
 */
public interface PersonService extends Remote {
    public List<PersonEntity> getList() throws RemoteException;
    public String helloWorld() throws RemoteException;
    public String sayHelloToSomeBody(String someBodyName) throws RemoteException;
    public byte[] downloadFile(String fileName) throws RemoteException;
}
