
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] word = str.toCharArray();
        for (int i = 0; i < word.length - 1; i++)
            if (word[i] >= word[i + 1] || word[i] < 'a' || word[i] > 'z')
            {
                System.out.println(0);
                return;
            }
        int len = word.length;
        int num = 0;

        for (int i = 1; i < len; i++)
            num += combination(26, i);

        if (len == 1)
            num = word[0] - 'a' + 1;
        else
        {
            int f = word[0] - 'a';
            for (int i = 1; i <= f; i++)
                num += combination(26 - i, len - 1);

            for (int i = 1; i < word.length; i++)
            {
                if (i == word.length - 1)
                    num += word[i] - word[i - 1];
                else
                    for (char j = (char) (word[i - 1] + 1); j < word[i]; j++)
                        num += combination('z' - j, len - i - 1);
            }
        }


        System.out.println(num);
    }


    public static int combination(int n, int m)
    {
        int ans = 1;
        for (int i = 1; i <= m; i++)
        {
            ans *= (n - m + i);
            ans /= i;
        }
        return ans;
    }
    
}