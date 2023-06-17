package com.common;

import java.io.Serializable;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sender;
    private String getter;
    private String content = "";
    private String sendTime = "";
    private byte[] bytes=new byte[0];

    // 一级业务类:0:登录/成功 1:无此用户 2:密码错误 3:用户已登录/注册 4:注册用户 5:退出登录
    //二级业务类: 6:显示在线用户 7:私聊 8:群发信息 9:发送文件
    private int type;

    public void addBytes(byte[] bytes)
    {
        byte[] bytes1 = new byte[this.bytes.length + bytes.length];
        for (int i = 0; i < this.bytes.length; i++)
        {
            bytes1[i] = this.bytes[i];
        }
        for (int i = 0; i < bytes.length; i++)
        {
            bytes1[i + this.bytes.length] = bytes[i];
        }
        this.bytes = bytes1;
    }

    public byte[] getBytes()
    {
        return bytes;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getGetter()
    {
        return getter;
    }

    public void setGetter(String getter)
    {
        this.getter = getter;
    }

    public String getContent()
    {
        return content;
    }

    public void addContent(String str)
    {
        this.content += str;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getSendTime()
    {
        return sendTime;
    }

    public void setSendTime(String sendTime)
    {
        this.sendTime = sendTime;
    }
}
