package Delivery_Return_Division;

import java.util.Scanner;

public class A93Combination {
    public static int n, m = 0;
    public static int[] ans;
    public static boolean[] used;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ans = new int[n+1];
        used = new boolean[n+1];
        combination(n,m,1);
        scanner.close();
    }

    public static void combination(int n, int m, int u) {
        if(u>m){
            for(int i=1;i<=m;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }
        //维护递增性
        int start = (u==1)? 1:ans[u-1]+1;
        for(int i = start; i<=n; i++){
            if(!used[i]){
                ans[u] = i;
                used[i] = true;
                combination(n,m,u+1);
                used[i] = false;
            }
        }
    }
}
