package Delivery_Return_Division;

import java.util.Scanner;

public class A1230KRange {
    static int N,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        long[] sum = new long[N + 1];
        int[] cnt = new int[K];
        for(int i = 1; i <= N; i++){
            sum[i] += sum[i-1]+sc.nextInt();
        }
        long res = 0;
        cnt[0]++;
        for(int R = 1;R<=N;R++){
            res += cnt[(int)(sum[R]%K)];
            cnt[(int)(sum[R]%K)]++;
        }
        System.out.println(res);
        sc.close();
    }
}
