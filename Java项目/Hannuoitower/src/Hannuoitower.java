import java.util.*;
public class Hannuoitower
{
    public static void main(String[] args)
    {
        var input=new Scanner(System.in);
        var tower=new Tower();
        int num=input.nextInt();
        tower.move(num,'A','B','C');
    }
}
class Tower
{
    //所有盘要上小下大从a塔移动到c塔上，小盘必须在大盘上。
    //移动方法
    //num表示是要移动的数量，,b,c分别表示A塔，B塔,C塔。
    //move负责移动它盘。
    /*可运用物理系统思维来理解，如：底盘和它盘为一个系统；
      它盘中的新底盘和新它盘为一个新系统；新它盘和~~*/
    public  void move(int num,char A ,char B,char C)
    {

        if(num == 1)//若只有一个盘，num=1
        {
            System.out.println(A+"->"+C);//从a移动到c
        }
        else //若有多个盘，可看作两个盘，即底盘和它盘（num-1)。
        {
            //1.先移动它盘到B塔（作为跳板）。
            move(num - 1 , A,C,B);
            //2.再把底盘移动到C塔
            System.out.println(A+"->"+C);
            //3.再把B塔上的它盘移动到C塔
            move(num-1,B , A,C);
        }
    }
}
