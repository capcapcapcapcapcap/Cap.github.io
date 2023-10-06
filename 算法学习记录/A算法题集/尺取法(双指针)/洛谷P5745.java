import java.io.*;
import java.util.*;


public class 洛谷P5745
{
	public static void main(String[] args) throws Exception
	{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int l=0,r=0;
		int ll=0,rr=0;
		st.nextToken();
		int n=(int)st.nval;
		int[] num=new int[n+1];
		long sum=0;
		long max=0;
		st.nextToken();
		int M=(int)st.nval;
		for(int i=0;i<n;i++)
		{
			st.nextToken();
			num[i]=(int)st.nval;
		}
		while(l<n)
		{
			while(r<n&&sum+num[r]<=M)
			{
				sum+=num[r];
				r++;
			}
			if(sum<=M&&sum>max)
			{
				max=sum;
				rr=r;
				ll=l;
			}
			sum-=num[l];
			l++;
		}
		System.out.println(ll+1+" "+rr+" "+max);
	}
}