package Dp_Math;

import java.util.*;

public class A1214DownUpSeq {
    static int[][] dp = new int[1010][1010];
    static int mod = 100000007;

    static int MOD(int a, int b) {
        return ((a % b) + b) % b;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = (dp[i - 1][MOD(j - (n - i) * a, n)] + dp[i - 1][MOD(j + (n - i) * b, n)]) % mod;
            }
        }
        System.out.println(dp[n - 1][MOD(sum, n)]);
        s.close();
    }
}
