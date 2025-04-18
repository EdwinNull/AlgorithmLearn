package Dp_Math;

import java.util.*;

public class A1246Numbers {
    static int MAXN = 100010;
    static int n;
    static int[] nums = new int[MAXN];
    
    public static int gcd(int a,int b){
        return b == 0? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums, 1, n+1);
        int max = nums[n];
        int min = nums[1];
        int g = 0;
        for(int i =2;i<=n;i++){
            g = gcd(g,nums[i]-nums[1]);
        }
        if(g==0) System.out.println(n);
        else{
            System.out.println((max-min)/g+1);
        }
        sc.close();
    }
}
