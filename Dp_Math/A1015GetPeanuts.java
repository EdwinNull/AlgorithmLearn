package Dp_Math;

import java.util.*;

public class A1015GetPeanuts {
    static int T,col,row;
    static int[][] dp,peanut;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int i = 1;i<=T;i++){
            row = sc.nextInt();
            col = sc.nextInt();
            dp = new int[row + 1][col + 1];
            peanut = new int[row + 1][col + 1];
            for (int j = 1; j <= row; j++) {
                for (int k = 1; k <= col; k++) {
                    peanut[j][k] = sc.nextInt();
                }
            }
            dynamic(dp,peanut,row,col);
        }
        sc.close();
    }

    public static void dynamic(int[][] dp,int[][] peanut,int row,int col){
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + peanut[i][j];
            }
        }
        System.out.println(dp[row][col]);
    }
}
