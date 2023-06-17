package com.server;

import com.common.*;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class ServerThread extends Thread {
    private Socket socket = null;
    private User user = null;
    private boolean online = true;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void time()
    {
        System.out.println(sdf.format(new Date()) + "");
    }

    public ServerThread(Socket socket, User user)
    {
        this.socket = socket;
        this.user = user;
    }

    public void setOnline(boolean online)
    {
        this.online = online;
    }

    public void send(Message mes)
    {
        try
        {
            ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
            objout.writeObject(mes);
            objout.flush();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public User getUser()
    {
        return user;
    }

    //和客户端保持通讯链接
    @Override
    public void run()
    {

        try
        {
            Thread.sleep(1000);

            //接收离线消息
            for (int i = 0; i < DataBase.messages.size(); i++)
            {
                Message getmes=DataBase.messages.get(i);
                if (getmes.getGetter().equals(user.getId()))
                {
                    DataBase.messages.remove(i);
                    try
                    {
                        ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
                        objout.writeObject(getmes);
                        objout.flush();
                    } catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        while (online)
        {
            try
            {
                //持续接收客户端的信息
                ObjectInputStream objin = new ObjectInputStream(socket.getInputStream());
                socket.setSoTimeout(5000);
                Message getmes = (Message) objin.readObject();

                switch (getmes.getType())
                {
                    case 6 ->
                    {
                        getmes.setSendTime(sdf.format(new Date()));
                        for (String id : DataBase.onlines)
                        {
                            getmes.addContent("用户 " + id + " 在线\n");
                        }
                        ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
                        objout.writeObject(getmes);
                        objout.flush();
                    }
                    case 7 ->
                    {
                        time();
                        ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
                        if (DataBase.onlines.contains(getmes.getGetter()))
                        {
                            System.out.println("用户 " + getmes.getSender() + " 向用户 " + getmes.getGetter() + " 发送了一条在线消息!");
                            getmes.setType(7);
                            DataBase.getSer(getmes.getGetter()).send(getmes);
                            getmes.setType(0);
                            objout.writeObject(getmes);
                            objout.flush();
                        } else
                        {
                            System.out.println("用户 " + getmes.getSender() + " 向用户 " + getmes.getGetter() + " 发送了一条离线消息!");

                            getmes.setType(-1);
                            objout.writeObject(getmes);
                            objout.flush();
                            getmes.setType(7);
                            DataBase.messages.add(getmes);
                        }
                    }
                    case 8 ->
                    {
                        time();
                        System.out.println("用户 " + getmes.getSender() + " 向所有在线用户" + "群发了一条消息!");
                        for (ServerThread st : DataBase.getSers())
                        {
                            if (!st.getUser().getId().equals(user.getId()))
                                st.send(getmes);
                        }
                    }
                    case 9 ->
                    {
                        time();

                        ObjectOutputStream objout = new ObjectOutputStream(socket.getOutputStream());
                        if (DataBase.onlines.contains(getmes.getGetter()))
                        {
                            System.out.println("用户 " + getmes.getSender() + " 向用户 " + getmes.getGetter() + " 发送了一个在线文件!");
                            getmes.setType(9);
                            DataBase.getSer(getmes.getGetter()).send(getmes);
                            getmes.setType(1);
                            objout.writeObject(getmes);
                            objout.flush();
                        } else
                        {
                            System.out.println("用户 " + getmes.getSender() + " 向用户 " + getmes.getGetter() + " 发送了一个离线文件!");

                            getmes.setType(-2);
                            objout.writeObject(getmes);
                            objout.flush();
                            getmes.setType(9);
                            DataBase.messages.add(getmes);
                        }
                    }

                }
            } catch (Exception e)
            {
            }

        }
        try
        {
            socket.close();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
