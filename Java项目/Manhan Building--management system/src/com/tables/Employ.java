package com.tables;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Employ {
    private Integer ordinal;
    private String id;
    private String password;
    private String name;
    private String job;
    public Employ()
    {
    }
    public Employ(Integer ordinal, String id, String password, String name, String job)
    {
        this.ordinal = ordinal;
        this.id = id;
        this.password = password;
        this.name = name;
        this.job = job;
    }

    public Integer getOrdinal()
    {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal)
    {
        this.ordinal = ordinal;
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }
}
