

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args)
    {
        Stack<Character> cc = new Stack<>();
        Stack<Integer> ii = new Stack<>();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] arr = str.toCharArray();

        int sum=0;
        int i=-1;
        while(arr[++i]!='@') {
            switch (arr[i])
            {
                case '+':
                {
                    ii.push(ii.pop() + ii.pop());
                    break;
                }
                case '-':
                {
                    int next=ii.pop();
                    int prev=ii.pop();
                    ii.push(prev-next);
                    break;
                }

                case '*':
                {
                    ii.push(ii.pop()*ii.pop());
                    break;
                }
                case '/':
                {
                    int next=ii.pop();
                    int prev=ii.pop();
                    ii.push(prev/next);
                    break;
                }
                case '.':
                {
                    ii.push(sum);
                    sum=0;
                    break;
                }

                default:sum=sum*10+arr[i]-'0';
            }

        }
        System.out.println(ii.pop());

    }
}
