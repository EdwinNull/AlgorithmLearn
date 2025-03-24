package Dp_Math;

import java.util.*;

public class A1212SeekTreasure {
    static int N = 1000000007;
    static int M = 15;
    static int n,m,K;
    static int[][] house;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        K = sc.nextInt();
        int res = 0;
        house = new int[n+1][m+1];
        int [][][][] dp = new int[60][60][20][20];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                house[i][j] = sc.nextInt();
                house[i][j] ++;
            }
        }
        dp[1][1][0][0] = 1;
        dp[1][1][1][house[1][1]] = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                for(int k = 0;k<=K;k++){
                    for(int c = 0;c<M;c++){
                        dp[i][j][k][c] = (dp[i][j][k][c]+dp[i-1][j][k][c]) % N;
                        dp[i][j][k][c] = (dp[i][j][k][c] + dp[i][j-1][k][c]) % N;
                        if(house[i][j]==c && k>0){
                            for(int s = 0;s<house[i][j];s++){
                                dp[i][j][k][c] = (dp[i][j][k][c] + dp[i-1][j][k-1][s]) % N;
                                dp[i][j][k][c] = (dp[i][j][k][c] + dp[i][j-1][k - 1][s]) % N;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 1;i<M;i++){
            res = (res + dp[n][m][K][i]) % N;
        }
        System.out.println(res);
        sc.close();
    }
}
