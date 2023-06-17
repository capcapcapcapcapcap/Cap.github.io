package com.client;

import com.common.*;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class ClientThread extends Thread {
    private Socket socket;
    private boolean online = true;
    private User user;

    public ClientThread(Socket socket, User user)
    {
        this.socket = socket;
        this.user = user;
    }

    public void setOnline(boolean online)
    {
        this.online = online;
    }

    public Socket getSocket()
    {
        return socket;
    }

    public void setSocket(Socket socket)
    {
        this.socket = socket;
    }

    //该线程需在后台保持和服务端的链接,进行通讯
    @Override
    public void run()
    {
        while (online)
        {
            try
            {
                //若服务端未回送信息,该线程会阻塞
                ObjectInputStream objin = new ObjectInputStream(socket.getInputStream());
                socket.setSoTimeout(5000);
                Message getmes = (Message) objin.readObject();

                switch (getmes.getType())
                {
                    case -1 -> System.out.println("消息发送成功! 但用户 " + getmes.getGetter() + " 不在线!");
                    case -2 -> System.out.println("文件发送成功! 但用户 " + getmes.getGetter() + " 不在线!");
                    case 0 -> System.out.println("消息发送成功!");
                    case 1-> System.out.println("文件发送成功!");
                    case 6 ->
                    {
                        System.out.println(getmes.getSendTime());
                        System.out.println(getmes.getContent());
                    }
                    case 7 ->
                    {
                        System.out.println("\n\t\t\t\t\t-----------收到一条新的私聊消息!!!-----------");
                        System.out.println("\t\t\t\t\t" + getmes.getSendTime());
                        System.out.print("\t\t\t\t\t用户 " + getmes.getSender() + " : ");
                        System.out.println(getmes.getContent());
                    }
                    case 8 ->
                    {
                        System.out.println("\n\t\t\t\t\t-----------收到一条新的群发消息!!!-----------");
                        System.out.println("\t\t\t\t\t" + getmes.getSendTime());
                        System.out.print("\t\t\t\t\t用户 " + getmes.getSender() + " : ");
                        System.out.println(getmes.getContent());
                    }
                    case 9 ->
                    {
                        File file = new File("src/com/mails/getmail");
                        file.createNewFile();
                        FileOutputStream writer = new FileOutputStream(file);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(writer);
                        bufferedOutputStream.write(getmes.getBytes());
                        bufferedOutputStream.close();
                        System.out.println("\n\t\t\t\t\t-----------收到一个文件!!!-----------");
                        System.out.println("\t\t\t\t\t" + getmes.getSendTime());
                        System.out.println("\t\t\t\t\t用户 " + getmes.getSender() + " : ");
                        System.out.println("\t\t\t\t\t请于mails查看!");
                    }
                }
            } catch (SocketTimeoutException e)
            {
            } catch (Exception e)
            {
                throw new RuntimeException(e);
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
