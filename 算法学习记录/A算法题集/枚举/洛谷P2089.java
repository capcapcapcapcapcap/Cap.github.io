import java.util.*;
import java.lang.System;
import java.lang.Math;
public class 洛谷P2089
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] ans=new int[10000][10];
		int n=input.nextInt();
		int me=0;
		if(n<10||n>30)
		{
			System.out.println(0);
			return;
		}
		for(int a=1;a<=3;a++)
			for(int b=1;b<=3;b++)
				for(int c=1;c<=3;c++)
					for(int d=1;d<=3;d++)
						for(int e=1;e<=3;e++)
		for(int f=1;f<=3;f++)
			for(int g=1;g<=3;g++)
				for(int h=1;h<=3;h++)
					for(int i=1;i<=3;i++)
						for(int j=1;j<=3;j++)
						{
							if(a+b+c+d+f+g+h+i+j+e==n)
							{ans[me][0]=a;ans[me][1]=b;ans[me][2]=c;
							ans[me][3]=d;ans[me][4]=e;ans[me][5]=f;
							ans[me][6]=g;ans[me][7]=h;ans[me][8]=i;
							ans[me][9]=j;me++;}
						}
		System.out.println(me);
		for(int i=0;i<me;i++)									
		{
			for(int m:ans[i])
				System.out.print(m+" ");
			System.out.println();
		}
	}
}