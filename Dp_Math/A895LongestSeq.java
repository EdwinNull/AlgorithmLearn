package Dp_Math;

import java.util.*;

public class A895LongestSeq {
    static int N;
    static int[] nums;
    static int[] dp;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N+1];
        dp = new int[N+1];
        for(int i = 1;i<=N;i++){
            nums[i] = sc.nextInt();
        }
        int ans = 0;
        for(int i = 1;i<=N;i++){
            dp[i] = 1;
            for(int j = 1;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans =Math.max(dp[i],ans);
        }
        System.out.println(ans);
        sc.close();
    }
}
