package com.client;

import com.common.DataBase;
import com.common.Message;
import com.common.User;
import com.common.Utility;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Event {

    //一级菜单业务
    public static int login(User user)
    {
        System.out.print("请输入用户名: ");
        user.setId(Utility.InString());
        System.out.print("请输入密码: ");
        user.setPassword(Utility.InString());
        try
        {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

            //将输入的账户密码传给服务端验证
            ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
            Message sendmes = new Message();
            sendmes.setType(0);

            objout.writeObject(sendmes);
            objout.flush();
            objout.writeObject(user);
            objout.flush();
            //接收服务端传回的验证信息
            ObjectInputStream objin = new ObjectInputStream(socket.getInputStream());
            int type = -1;
            if (objin.readObject() instanceof Message getmes)
                type = getmes.getType();
            //对验证信息做出判断
            switch (type)
            {
                case 0 ->
                {
                    System.out.println("用户 " + user.getId() + " 登录成功!");
                    //启动一个客户端通讯线程
                    ClientThread comthread = new ClientThread(socket, user);
                    DataBase.addCli(user, comthread);
                    comthread.start();
                }
                case 1 ->
                {
                    System.out.println("该用户不存在!");
                    socket.close();
                }
                case 2 ->
                {
                    System.out.println("密码输入错误!");
                    socket.close();
                }
                case 3 -> System.out.println("用户 " + user.getId() + " 已登录!");
            }
            return type;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void logout(User user)
    {
        try
        {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            //将需要登出的账号传给服务端
            ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
//            user.setOnline(false);
            Message message = new Message();
            message.setType(5);

            objout.writeObject(message);
            objout.flush();
            objout.writeObject(user);
            objout.close();

            DataBase.delCli(user);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static int register(User user)
    {
        System.out.print("请输入注册用户名: ");
        user.setId(Utility.InString());
        System.out.print("请输入密码: ");
        user.setPassword(Utility.InString());

        try
        {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

            //将输入的账户密码传给服务端验证
            ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
            Message sendmes = new Message();
            sendmes.setType(4);

            objout.writeObject(sendmes);
            objout.flush();
            objout.writeObject(user);
            objout.flush();
            // 接收验证信息并处理
            ObjectInputStream objin = new ObjectInputStream(socket.getInputStream());
            int type = -1;
            if (objin.readObject() instanceof Message getmes)
                type = getmes.getType();

            switch (type)
            {
                case 0 -> System.out.println("用户 " + user.getId() + " 注册成功!\n");
                case 3 -> System.out.println("用户 " + user.getId() + " 已注册!");
            }
            return type;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    //二级菜单业务
    public static void onlineusers(User user)
    {
        try
        {
            ClientThread clientthread = DataBase.getCli(user);
            Socket socket = clientthread.getSocket();
            Message sendmes = new Message();
            sendmes.setType(6);
            //发送请求信息
            ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
            objout.writeObject(sendmes);

        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    public static void priChat(User sender)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ClientThread clientthread = DataBase.getCli(sender);
            Socket socket = clientthread.getSocket();
            //设置信息
            Message sendmes = new Message();
            sendmes.setType(7);
            sendmes.setSender(sender.getId());
            System.out.print("请选择要私聊的用户: ");
            sendmes.setGetter(Utility.InString());
            System.out.println("请输入要发送的信息:");
            sendmes.addContent(Utility.InString());
            sendmes.setSendTime(sdf.format(new Date()));
            //将输入的信息传给服务端验证
            ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
            objout.writeObject(sendmes);
            objout.flush();


        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void mass(User sender)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ClientThread clientthread = DataBase.getCli(sender);
            Socket socket = clientthread.getSocket();
            //设置信息
            Message sendmes = new Message();
            sendmes.setType(8);
            sendmes.setSender(sender.getId());
            System.out.println("请输入要群发的信息:");
            sendmes.addContent(Utility.InString());
            sendmes.setSendTime(sdf.format(new Date()));
            //将输入的信息传给服务端验证
            ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
            objout.writeObject(sendmes);
            objout.flush();

            System.out.println("消息已发送!");
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void sendFile(User sender)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ClientThread clientthread = DataBase.getCli(sender);
            Socket socket = clientthread.getSocket();
            //设置信息
            Message sendmes = new Message();
            sendmes.setType(9);
            sendmes.setSendTime(sdf.format(new Date()));
            sendmes.setSender(sender.getId());
            System.out.print("请选择要发送的用户: ");
            sendmes.setGetter(Utility.InString());
            System.out.println("请输入要发送文件的路径:");

            File file = new File(Utility.InString());
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream reader = new BufferedInputStream(fis);
            byte[] buffer = new byte[1024];
            int line=0;
            while((line = reader.read(buffer)) != -1)
                sendmes.addBytes(buffer);
            reader.close();
            //将输入的信息传给服务端
            ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
            objout.writeObject(sendmes);
            objout.flush();

        } catch (FileNotFoundException e)
        {
            System.out.println("查无此文件!!!");
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
