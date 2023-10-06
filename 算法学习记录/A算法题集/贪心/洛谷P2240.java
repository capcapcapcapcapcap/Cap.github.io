
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Main {
    static double[] weight;
    static double[] value;
    static List<Double> price;
    static int N;
    static double T;
    static double ans;
    static int left;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        N=(int)st.nval;
        st.nextToken();
        T=(int)st.nval;

        left=N;
        weight=new double[N+1];
        value = new double[N+1];
        price = new ArrayList<>();
        price.add(0.0);

        for(int i=1;i<=N;i++)
        {
            st.nextToken();
            weight[i] = (int)st.nval;
            st.nextToken();
            value[i] = (int)st.nval;
            price.add(value[i]/weight[i]);
        }
        while(T>0&&left!=0)
        {
            double max=Collections.max(price);
            int index=price.indexOf(max);
            double remain=Math.min(weight[index],T);
            ans+=remain*max;
            T-=remain;
            left--;
            price.set(index,0.0);
        }
        System.out.format("%.2f",ans);

    }
}