
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Main {
    
    static String str;
    static int k;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        str = st.nextToken();
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        char[] a = str.toCharArray();
        for (char ch : a)
            list.add(ch - '0');
        while (k-- > 0)
        {

            if (list.size() == 1)
                list.remove(0);
            else if (list.size() == 2)
            {
                if (list.get(0) > list.get(1))
                    list.remove(0);
                else list.remove(1);
            } else
            {
                for (int i = 0; i < list.size();i++)
                {

                    int now = list.get(i);
                    if(i==0)
                    {
                        if(now > list.get(i+1))
                        {
                            list.remove(i);
                            break;
                        }
                        else continue;
                    }

                    int pre = list.get(i - 1);
                    if(i==list.size()-1)
                    {
                        if (now >= pre)
                            list.remove(i);
                        else list.remove(i - 1);
                        break;
                    }

                    int next = list.get(i + 1);
                    boolean flag=true;
                    for(int j=0;j<i;j++)
                    {
                        pre=list.get(j);
                        if(now<pre)
                            flag=false;
                    }
                    if (flag && now > next)
                    {
                        list.remove(i);
                        break;
                    }
                }
            }
        }

        boolean flag=false;
        for (int now : list)
        {
            if(now>0)
                flag=true;
            if(flag)
                System.out.print(now);

        }
        if(!flag)
            System.out.print(0);
    }


}