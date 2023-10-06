import java.util.*;
import java.io.*;

public class 洛谷P1923
{
	static int k=0;
	static int ans=0;
	public static void main(String[] args) throws Exception {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int n=(int)st.nval;
		st.nextToken();
		 k=(int)st.nval;
		int[] nums=new int[n];
		
		for(int i=0;i<n;i++)
		{
			st.nextToken();
			nums[i]=(int)st.nval;
		}
		// Arrays.sort(nums);
		find(0,n-1,nums);
		System.out.println(ans);
	}
	static void find(int l,int r,int[] a)
	{
		if(l==r)
		{
			ans=a[l];
			return;
		}
		int flag=a[(r+l)/2];
		int i=l,j=r;
		do
		{
			while(a[i]<flag) i++;
			while(a[j]>flag) j--;
			if(i<=j)
			{
				int tmp=a[i];
				a[i++]=a[j];
				a[j--]=tmp;
			}
		}while(i<=j);

		if(k<=j) find(l,j,a);
		else if(i<=k) find(i,r,a);
		else find(j+1,i-1,a);
	}
}