import java.util.Scanner;

public class 洛谷P1028{
    static int[] f;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        f = new int[n + 1];
        f[1] = 1;
        System.out.print(solve(n));
    }
    static int solve(int x)
    {
        int ans = 1;
        if (f[x] != 0)
            return f[x];
        for (int i = 1; i <= x / 2; i++)
            ans += solve(i);
        return f[x] = ans;
    }
}