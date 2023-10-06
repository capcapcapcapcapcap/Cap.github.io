import java.io.*;
import java.util.*;

public class Main
{
	static int N;
	static int M;
	static int[] tree;
	public static void main(String[] args) throws IOException{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	    st.nextToken();
	    N=(int)st.nval;
	    st.nextToken();
	    M=(int)st.nval;
	    tree=new int[N+1];
	    for(int i=1;i<=N;i++)
	    {
	    	st.nextToken();
	    	tree[i]=(int)st.nval;
	    }
	    Arrays.sort(tree);
	    int ans=0;
	    int l=tree[1];
	    int r=tree[N];
	    while(l<r)
	    {
	    	int mid=(r+l+1)/2;
	    	if(check(mid))
	    	{
	    		ans=mid;
	    		l=mid;
	    	}else r=mid-1;
	    }
	    System.out.print(ans);
	}
	static boolean check(int x)
	{
		int sum=0;
		for(int i=1;i<=N;i++)
		{
			if(tree[i]>=x)
				sum+=tree[i]-x;
			if(sum>=M)
				return true;
		}
		return false;
	}
}