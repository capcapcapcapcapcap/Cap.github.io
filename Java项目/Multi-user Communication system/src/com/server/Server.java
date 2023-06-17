package com.server;

import com.common.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Server {
    private ServerSocket sersoc = new ServerSocket();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void time()
    {
        System.out.println(sdf.format(new Date()) + "");
    }
    public Server() throws Exception
    {
        try
        {
            sersoc = new ServerSocket(9999);
            while (true)
            {
                Socket socket = sersoc.accept();

                User user = new User();
                Message sendmes = new Message();

                ObjectInputStream objin = new ObjectInputStream(socket.getInputStream());


                if (objin.readObject() instanceof Message getmes)
                {
                    time();
                    switch (getmes.getType())
                    {
                        //用户登录业务
                        case 0 ->
                        {
                            user = (User) objin.readObject();
                            sendmes.setType(DataBase.checkuser(user));

                            switch (sendmes.getType())
                            {
                                case 0 ->
                                {

                                    System.out.println("用户 " + user.getId() + " 已上线!");
                                    ServerThread serverThread = new ServerThread(socket, user);
                                    DataBase.addSer(user, serverThread);
                                    serverThread.start();
                                }
                                case 2 -> System.out.println("用户 " + user.getId() + " 尝试登录失败!");
                            }
                        }
                        //用户注册业务
                        case 4 ->
                        {
                            user = (User) objin.readObject();
                            sendmes.setType(DataBase.adduser(user));
                            if (sendmes.getType() == 0)
                                System.out.println("用户 " + user.getId() + " 注册成功!");
                        }

                        //用户登出业务
                        case 5 ->
                        {
                            user = (User) objin.readObject();
                            DataBase.offline(user);
                            System.out.println("用户 " + user.getId() + " 已下线!");
                        }
                    }
                }
                //验证传入的登录用户信息是否正确

                ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
                objout.writeObject(sendmes);
                objout.flush();
            }
        } catch (IOException e)
        {
            sersoc.close();
        }
    }


    public static void main(String[] args) throws Exception
    {
        new Server();
    }
}
