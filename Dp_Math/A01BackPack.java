package Dp_Math;

import java.util.*;

public class A01BackPack {
    static int N,V;
    static int[] volume,w;
    static int[] dp;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();
        volume = new int[N+1];
        w = new int[N+1];
        dp = new int[V+1];
        for(int i =1;i<=N;i++){
            volume[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        for(int i =1;i<=N;i++){
            for(int j = V;j>=0;j--){
                dp[j] = dp[j];
                if(j >= volume[i]){
                    //优化空间，关键在于判断如何使优化前后等价
                    dp[j] = Math.max(dp[j],dp[j-volume[i]]+w[i]);
                }
            }
        }
        System.out.println(dp[V]);
        sc.close();
    }   
}
