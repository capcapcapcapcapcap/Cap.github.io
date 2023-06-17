package com.common;

import com.client.*;
import com.server.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class DataBase {
    //存放每个客户端用户和对应的通讯线程
    public static final HashMap<String, ClientThread> clithreads = new HashMap<>();

    //添加用户和通讯线程
    public static void addCli(User user, ClientThread comthread)
    {
        clithreads.put(user.getId(), comthread);
    }

    public static ClientThread getCli(User user)
    {
        return clithreads.getOrDefault(user.getId(), null);
    }

    public static void delCli(User user)
    {
        clithreads.get(user.getId()).setOnline(false);
        clithreads.remove(user.getId());
    }


    //存放服务端对应的通讯线程
    private static final HashMap<String, ServerThread> serthreads = new HashMap<>();

    public static void addSer(User user, ServerThread serverthread)
    {
        serthreads.put(user.getId(), serverthread);
    }

    public static Collection<ServerThread> getSers()
    {
        return serthreads.values();
    }

    public static ServerThread getSer(User user)
    {
        return serthreads.getOrDefault(user.getId(), null);
    }

    public static ServerThread getSer(String id)
    {
        return serthreads.getOrDefault(id, null);
    }

    public static void delSer(User user)
    {
        serthreads.get(user.getId()).setOnline(false);
        serthreads.remove(user.getId());
    }

    //存放用户信息
    public static final HashMap<String, String> users = new HashMap<>();
    static
    {
        users.put("10001", "123456");
        users.put("10002", "123456");
        users.put("10003", "123456");
    }
    public static int adduser(User user)
    {
        if (users.containsKey(user.getId()))
            return 3;
        else
        {
            users.put(user.getId(), user.getPassword());
            return 0;
        }
    }

    //存放离线消息
    public static final ArrayList<Message> messages = new ArrayList<>();


    //管理在线用户
    public static Vector<String> onlines = new Vector<>();
    public static void offline(User user)
    {
        onlines.remove(user.getId());
        delSer(user);
    }

    public static int checkuser(User user)
    {
        if (users.containsKey(user.getId()))
        {
            if (onlines.contains(user.getId()))
                return 3;

            else if (user.getPassword().equals(users.get(user.getId())))
            {
                onlines.add(user.getId());
                user.setOnline(true);
                return 0;
            } else
                return 2;
        } else
            return 1;
    }



}
