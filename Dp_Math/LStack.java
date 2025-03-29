package Dp_Math;

import java.util.Scanner;

public class LStack {
    public static void main(String[] args) {
        // mem = new int[2 * n + 1][n + 2]; //记忆化数组，加速用的
        // int result = ways(0, 0);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[2*n+1][n+1];
        dp[0][0] = 1;
        for (int i = 0; i < 2*n; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j] == 0) continue;
                if (j < n) {
                    dp[i + 1][j + 1] += dp[i][j];
                }
                if (j > 0) {
                    dp[i + 1][j - 1] += dp[i][j];
                }
            }
        }

        System.out.println(dp[2 * n][0]);
        scanner.close();
    }
}

    // public static int ways(int step, int stackSize) {
    //     if (step == 2 * n) {
    //         return stackSize == 0 ? 1 : 0;
    //     }
    //     if (mem[step][stackSize] != 0) {
    //         return mem[step][stackSize];
    //     }

    //     int count = 0;
    //     // push的话，栈-1
    //     if (stackSize <= n) {
    //         count += ways(step + 1, stackSize + 1);
    //     }
    //     // pop的话，栈+1
    //     if (stackSize > 0) {
    //         count += ways(step + 1, stackSize - 1);
    //     }

    //     //存结果
    //     mem[step][stackSize] = count;
    //     return count;
    // }
