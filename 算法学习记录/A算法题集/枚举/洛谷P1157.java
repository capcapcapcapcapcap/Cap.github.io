import java.util.Scanner;
import java.lang.System;


public class 洛谷P1157
{
	static int n;
	static int r;
	static int[] a=new int[100];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n=input.nextInt();
		r=input.nextInt();
		dfs(1);
	}

	static void dfs(int k)
	{

		if(k>r)
		{	for(int i=1;i<=r;i++)
				System.out.printf("%3d", a[i]);
			System.out.println();
			return ;
		}
		for(int i=a[k-1]+1;i<=n;i++)
		{
			a[k]=i;
			dfs(k+1);
		}

	}
}