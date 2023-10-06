import java.util.*;
import java.lang.System;
import java.lang.Math;

public class 洛谷P2241
{
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x=input.nextInt();
        int y=input.nextInt();
        long squ=0;
        long rec=0;
        for(int i=1;i<=Math.min(x, y);i++)
            squ+=(long)(x+1-i)*(y+1-i);
        rec=((long) x *(x+1)*y*(y+1))/4-squ;
        System.out.print(squ+" "+rec);
	}
}