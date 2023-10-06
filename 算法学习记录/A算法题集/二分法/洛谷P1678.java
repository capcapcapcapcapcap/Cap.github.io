import java.io.*;
import java.util.*;

public class Main
{
	static int M;
	static int N;
	static int[] sc;
	static int[] std;
	public static void main(String[] args) throws Exception{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	    st.nextToken();
	    M=(int)st.nval;
	    st.nextToken();
	    N=(int)st.nval;
	    sc=new int[M+2];
	    std=new int[N+1];
	    for(int i=1;i<=M;i++)
	    {
	    	st.nextToken();
	    	sc[i]=(int)st.nval;
	    }
	    for(int i=1;i<=N;i++)
	    {
	    	st.nextToken();
	    	std[i]=(int)st.nval;
	    }
	    Arrays.sort(sc,1,M+1);
	    long ans=0;
	    for(int i=1;i<=N;i++)
		{
			int l=1;
			int r=M;
			int node=1;
			while(l<r)
			{
				int mid=(r+l+1)>>1;
				if(std[i]==sc[mid])
					{
						node=0;
						break;
					}
				else if(std[i]>sc[mid])
					l=mid;
				else r=mid-1;
			}
			
			int a=Math.abs(std[i]-sc[l]);
			int b=Math.abs(std[i]-sc[l+1]);
			if(M==1)
				ans+=sc[1];
			else if(node!=0)
				ans+=Math.min(a,b);
			
				
		}
		System.out.print(ans);
	}
	
}