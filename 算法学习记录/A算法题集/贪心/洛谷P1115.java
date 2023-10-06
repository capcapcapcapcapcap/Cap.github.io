

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Main{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max=1<<31;
        int sum=0;
        for (int i = 0; i < t; i++)
        {
            int num=Integer.parseInt(st.nextToken());
            sum+=num;
            max=Math.max(max,sum);
            sum=Math.max(sum,0);
            
        }
        
        System.out.println(max);
    }
}
