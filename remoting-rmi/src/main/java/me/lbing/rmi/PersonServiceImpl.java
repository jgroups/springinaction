package me.lbing.rmi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by King on 2016/6/3.
 */
public class PersonServiceImpl extends UnicastRemoteObject implements PersonService {

    public PersonServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<PersonEntity> getList() throws RemoteException {
        System.out.println("Get Person Start!");
        List<PersonEntity> personList = new LinkedList<PersonEntity>();

        PersonEntity person1 = new PersonEntity();
        person1.setAge(25);
        person1.setId(0);
        person1.setName("Leslie");
        personList.add(person1);

        PersonEntity person2 = new PersonEntity();
        person2.setAge(25);
        person2.setId(1);
        person2.setName("Rose");
        personList.add(person2);

        return personList;
    }

    /**
     * 简单的返回“Hello World！"字样
     *
     * @return 返回“Hello World！"字样
     * @throws java.rmi.RemoteException
     */
    @Override
    public String helloWorld() throws RemoteException {
        return "Hello World!";
    }

    /**
     * 一个简单的业务方法，根据传入的人名返回相应的问候语
     *
     * @param someBodyName 人名
     * @return 返回相应的问候语
     * @throws java.rmi.RemoteException
     */
    @Override
    public String sayHelloToSomeBody(String someBodyName) throws RemoteException {
        System.out.println("hahhahah,已经调用到远程了.");
        return "你好，" + someBodyName + "!";
    }

    public byte[] downloadFile(String fileName) throws RemoteException {

        File file = new File(fileName);

        byte buffer[] = new byte[(int) file.length()];

        int size = buffer.length;

        System.out.println("download file size = " + size + "b");

        if (size > 1024 * 1024 * 10) {//限制文件大小不能超过10M，文件太大可能导制内存溢出！

            throw new RemoteException("Error:<The File is too big!>");

        }

        try {

            BufferedInputStream input = new BufferedInputStream(

                    new FileInputStream(fileName));

            input.read(buffer, 0, buffer.length);

            input.close();

            System.out.println("Info:<downloadFile() hed execute successful!>");

            return buffer;

        } catch (Exception e) {

            System.out.println("FileUtilImpl: " + e.getMessage());

            e.printStackTrace();

            return null;

        }

    }
}
