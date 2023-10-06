package com.vj726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class MainE {
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        String[] nodes=new String[(int)st.nval];
        st.nextToken();
        int q=(int)st.nval;
        for(int i = 0; i < nodes.length; i++)
        {
            st.nextToken();
            nodes[i] = String.valueOf((int)st.nval);
        }
        Arrays.sort(nodes);
        for(int i=0;i<q;i++)
        {
            st.nextToken();
            st.nextToken();
            String str=String.valueOf((int)st.nval);
            LinkedList<Integer> list=new LinkedList<>();
            for(String s:nodes)
            {
                if(s.endsWith(str))
                    list.add(Integer.parseInt(s));
            }
            if(list.isEmpty())
                System.out.println(-1);
            else System.out.println(Collections.min(list));
        }
    }

}
