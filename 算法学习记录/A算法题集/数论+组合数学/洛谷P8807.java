
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main{
    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args)
    {
        PrintWriter out = new PrintWriter(System.out);
        FastReader in=new FastReader();
        int t=in.nextInt();
        while(t-->0)
        {
            int n=in.nextInt();
            int m=in.nextInt();
            boolean ans=false;
            for(int i=1;i<=m;i++)
            {
                for(int j=i-1;j>=1;j--)
                {
                    if(n%i==n%j)
                        ans=true;
                    if(ans)
                        break;
                }
                if(ans)
                    break;
            }
            if(ans)
                out.println("Yes");
            else out.println("No");
        }
        out.close();
    }
}
//ax+o=by+p
//o=p