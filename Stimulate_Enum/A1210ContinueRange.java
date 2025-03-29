package Stimulate_Enum;

import java.util.*;

public class A1210ContinueRange {
    static int N;
    static int[] nums = new int[100001];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int res = 0;
        for(int i = 0;i<N;i++){
            nums[i] = sc.nextInt();
        }
        for(int i =0;i<N;i++){
            int min = 10000000;
            int max = -min;
            for(int j = i;j<N;j++){
                min = Math.min(min,nums[j]);
                max = Math.max(max, nums[j]);
                if(max-min == j-i){
                    res ++;
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
}
