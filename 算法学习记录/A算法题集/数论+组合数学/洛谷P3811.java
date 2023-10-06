import java.io.*;


public class MainD {
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);

        st.nextToken();
        int n=(int)st.nval;
        st.nextToken();
        int p = (int) st.nval;

        int[] inv;
        long res=0;
        inv = new int[n+1];
        inv[1] = 1;
        inv[2] = (p - (p / 2)) % p;

        for (int i = 3; i <= n; i++){
            res = p-(long)inv[p%i]*(p/i)%p;
            inv[i] = (int) res;
        }
        for (int i = 1; i <= n; i++)
        {
            pw.println(inv[i]);
            pw.flush();
        }
        pw.close();
    }

}

