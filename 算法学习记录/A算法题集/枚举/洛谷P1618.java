import java.util.*;


public class 洛谷P1618
{
	static boolean[] num ;
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);

        int A = input.nextInt();

        int B = input.nextInt();
        int C = input.nextInt();
        boolean flag2 = true;
        for (int i = 192; i < 333; i++)
        {
        	if(A==0||B==0||C==0)
        	break;
            num= new boolean[10];
            num[0]=true;
            if ((i * B )% A != 0 || (i * C) % A != 0)
                continue;
            int j = i * B / A ;
            int k = i *C / A  ;
            if(j>987||k>987)
            	break;
            go(j);
            go(k);
            go(i);
            boolean flag = true;
            for (boolean m : num)
                if (!m)
                {
                    flag = false;
                    break;
                }
            if (flag)
            {
                System.out.println(i + " " + j + " " + k);
                flag2 = false;
            }


        }
        if (flag2)
            System.out.println("No!!!");

    }

    static void go(int x)
    {
        num[x / 100] = true;
        num[x / 10 % 10] = true;
        num[x % 10] = true;
    }
}