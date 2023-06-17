package com.common;

import java.io.Serializable;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String password;
    private boolean online=true;

    public boolean isOnline()
    {
        return online;
    }

    public void setOnline(boolean online)
    {
        this.online = online;
    }

    public User(String id, String password)
    {
        this.id = id;
        this.password = password;
    }

    public User()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }



}
