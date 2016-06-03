package me.lbing.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by King on 2016/6/3.
 */
public class Program {
    public static void main(String[] args) {
        System.out.println("服务端");
        try {
            PersonService personService = new PersonServiceImpl();
            //注册通讯端口
            LocateRegistry.createRegistry(6600);
            //注册通讯路径
            Naming.rebind("rmi://127.0.0.1:6600/PersonService", personService);
            System.out.println("Service Start!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("客户端");
        try {
            //调用远程对象，注意RMI路径与接口必须与服务器配置一致
            PersonService personService = (PersonService) Naming.lookup("rmi://127.0.0.1:6600/PersonService");

            //service1
            List<PersonEntity> personList = personService.getList();
            for (PersonEntity person : personList) {
                System.out.println("ID:" + person.getId() + " Age:" + person.getAge() + " Name:" + person.getName());
            }

            //service2
            String s = personService.helloWorld();
            System.out.println(s);

            //service3
            String hh = personService.sayHelloToSomeBody("King");
            System.out.println(hh);

            //service4
            byte[] filedata = personService.downloadFile("D:\\test\\01.xlsx");
            System.out.println("文件的长度是:"+filedata.length);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
