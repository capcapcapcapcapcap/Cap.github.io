import java.util.Scanner;
import java.lang.System;


public class 洛谷P1036
{
	static int n;
	static int K;
	static int ans=0;
	static int[] a;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n=input.nextInt();
		K=input.nextInt();
		a =new int[n];
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		dfs(0,0,0);
		System.out.print(ans);
	}

	static void dfs(int m, int sum, int startx)
	{
	    if(m == K){
	        if(isPrime(sum))
	            ans++;
	        return ;
	    }
	    for(int i = startx; i < n; i++)
	        dfs(m + 1, sum + a[i], i + 1);
	    return ;
	}	
	static boolean isPrime(int x)
	{
		if(x<=1)
			return false;

		for(int i=2;i*i<=x;i++)
		{
			if(x%i==0)
				return false;
				
		}
		return true;
	}	

}