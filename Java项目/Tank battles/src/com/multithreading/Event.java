package com.multithreading;

import java.util.ArrayList;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 * 事件处理
 */
public class Event {
    //队友伤害模式
    public static boolean Teamate_damage;

    //对坦克和子弹的存活进行判断,并进行相应处理
    public static void beAlive()
    {
        for (int j = 0; j < Database.allbullets.size(); j++)
        {
            Bullet bullet = Database.allbullets.get(j);
            // 判断子弹是否存活
            if (!bullet.isAlive)
                continue;
            //判断坦克是否存活
            for (PlayerTank tank1 : Database.alltanks)
            {
                //如过坦克1已死亡,则跳过
                if (!tank1.isAlive)
                    continue;
                //判断该子弹是否有击中坦克1
                //可选择是否开启[队友伤害]模式
                if (Teamate_damage)
                    hit1(tank1, bullet);
                else
                {
                    if (bullet.friend != tank1.isFriend())
                        hit1(tank1, bullet);
                }
                //若坦克1仍存活,判断坦克1,2是否相撞
                if (tank1.isAlive)
                {
                    for (int i = Database.alltanks.indexOf(tank1) + 1; i < Database.alltanks.size(); i++)
                    {
                        PlayerTank tank2 = Database.alltanks.get(i);
                        //若坦克2还活着则判断
                        if (tank2.isAlive)
                        {
                            hit2(tank1, tank2);
                        }
                        //若已相撞
                        if (!tank1.isAlive)
                        {
                            break;
                        }
                    }
                }
            }
        }
    }

    //子弹击中坦克事件
    public static void hit1(PlayerTank tank, Bullet bullet)
    {
        //判断子弹是否击中坦克
        if ((bullet.x + bullet.width - 1) > (tank.x) && (bullet.x < (tank.x + 35)) && (bullet.y + bullet.height - 1) > (tank.y) && (bullet.y < (tank.y + 35)))
        {
            remainLives(tank, bullet);
            bullet.isAlive = false;
        }
    }

    //坦克碰撞事件
    public static void hit2(PlayerTank me, PlayerTank en)
    {
        //若均是同一方坦克,则无视碰撞
        if (me.isFriend() == en.isFriend())
            return;
        if (me.x + 36 > en.x && me.x < en.x + 36 && me.y + 36 > en.y && me.y < en.y + 37)
        {
            //直接死亡
            en.isAlive = false;
            me.isAlive = false;
            //添加坦克爆炸效果
            Database.allexplosions.add(new Explosion(me));
            Database.allexplosions.add(new Explosion(en));
        }
    }

    //生命计算
    public static void remainLives(PlayerTank tank, Bullet bullet)
    {
        int lives = tank.getLives();
        //坦克减命或死亡
        if (lives > 0)
        {
            lives -= bullet.attack;
            tank.setLives(lives);
            if (tank.getLives() <= 0)
            {
                tank.isAlive = false;
                Database.allexplosions.add(new Explosion(tank));
            } else //添加子弹爆炸效果
                Database.allexplosions.add(new Explosion(bullet));
        } else
        {
            tank.isAlive = false;
            //添加坦克死亡爆炸效果
            Database.allexplosions.add(new Explosion(tank));
        }
    }

    //清除已死亡的子弹
    public static void removeBullet()
    {
        ArrayList<Bullet> bullets = new ArrayList<>();
        for (int i = 0; i < Database.allbullets.size(); i++)
        {
            Bullet bullet = Database.allbullets.get(i);
            if (!bullet.isAlive)
                bullets.add(bullet);
        }
        Database.allbullets.removeAll(bullets);
    }
}
