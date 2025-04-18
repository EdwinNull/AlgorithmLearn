package Dp_Math;

import java.util.Scanner;

public class A1050Naruto {
    static int t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int T=1;T<=t;T++){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[][] dp = new int[M+1][N+1];
            dp[0][0] = 1;
            for(int i = 0; i <= M; i++){
                for(int j = 1; j <= N; j++){
                    dp[i][j] = dp[i][j-1];
                    if(i>=j){
                        dp[i][j] += dp[i-j][j];
                    }
                }
            }
            System.out.println(dp[M][N]);
        }
        sc.close();
    }
}
