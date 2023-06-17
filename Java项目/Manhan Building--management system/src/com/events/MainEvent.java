package com.events;

import com.daos.BasicDao;
import com.utilities.IO_Utility;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class MainEvent {
    public static boolean userLogin()
    {
        System.out.print("请输入账号/邮箱: ");
        String id = IO_Utility.InString();
        System.out.print("请输入密码: ");
        String password = IO_Utility.InString();

        //与数据库比对信息
        String sql = "select pwd from `user` where id=? or email=?";
        Object pwd = BasicDao.selectOne(sql, id, id);
        if (pwd != null)
        {
            if (password.equals((String) pwd))
            {
                sql = "select nickname from `user` where id=? or email=?";
                String name = (String) BasicDao.selectOne(sql, id, id);
                System.out.println("用户 " + name + " 登陆成功!");
                return true;
            } else
                System.out.println("密码错误,请重新登录!");
        } else
            System.out.println("该账号未注册,请重新登录/注册账号!");
        return false;

    }

    public static void userRegister()
    {
        boolean loop1;
        String email;
        do
        {
            System.out.print("请输入注册邮箱: ");
            email = IO_Utility.InString();
            while(!email.matches("\\w+@\\w+\\.com"))
            {
                System.out.print("邮箱格式不正确,请重新输入: ");
                email = IO_Utility.InString();
            }
            String sql1 = "select email from `user` where email=?";
            String str1 = (String) BasicDao.selectOne(sql1, email);
            if (str1 != null)
            {
                System.out.println("该邮箱已注册!");
                loop1 = true;
            } else
                loop1 = false;
        } while (loop1);

        boolean loop2;
        String id;
        do
        {
            System.out.print("请输入用户名: ");
            id = IO_Utility.InString();
            String sql2 = " select id from `user` where id=?";
            String str2 = (String) BasicDao.selectOne(sql2, id);
            if (str2 != null)
            {
                System.out.println("该用户名已被使用!");
                loop2 = true;
            } else
                loop2 = false;
        } while (loop2);
        System.out.print("请输入昵称: ");
        String nickname = IO_Utility.InString();
        System.out.print("请输入密码: ");
        String password = IO_Utility.InString();

        String sql = "insert into `user`(id,nickname,pwd,`email`) value(?,?,?,?)";
        BasicDao.update(sql, id, nickname, password, email);
        System.out.println("用户 " + id + "(" + nickname + ") 注册成功!");
    }

    public static boolean employLogin()
    {
        System.out.print("请输入账号: ");
        String id = IO_Utility.InString();
        System.out.print("请输入密码: ");
        String password = IO_Utility.InString();

        //与数据库比对信息
        String sql = "select pwd from `employ` where id=?";
        Object pwd = BasicDao.selectOne(sql, id);
        if (pwd != null)
        {
            if (password.equals((String) pwd))
            {
                sql = "select name from `employ` where id=?";
                String name = (String) BasicDao.selectOne(sql, id);
                System.out.println("员工 " + name + "(" + id + ") 登陆成功!");
                return true;
            } else
                System.out.println("密码错误,请重新登录!");
        } else
            System.out.println("无此员工,请重新登录!");
        return false;
    }

    public static boolean quit()
    {
        System.out.print("请问是否确认退出本系统(y/n): ");
        return !IO_Utility.Inchoice();
    }
}
