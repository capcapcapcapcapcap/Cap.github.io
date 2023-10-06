
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int r = (int) st.nval;

        int k=n;
        StringBuilder str=new StringBuilder();
        //（商+1）*除数+（余数-除数）=商*除数+除数+余数-除数=商*除数+余数=被除数
        while(n!=0)
        {
            int m=n%r;
            if(m<0)
            {
                m-=r;
                n+=r;
            }

            if(m>=10)
                m+='A'-10;
            else m+='0';
            n/=r;
            str.insert(0,(char) m);
        }
        System.out.format("%d=%s(base%d)",k,str,r);

    }
}