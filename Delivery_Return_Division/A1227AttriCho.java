package Delivery_Return_Division;

import java.util.Scanner;

public class A1227AttriCho {
    static int N,K;
    static int[] h = new int[100010];
    static int[] w = new int[100010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        for(int i = 0;i<N;i++){
            h[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int l =1,r = 100000;
        while(l<r){
            int mid = (l+r+1)/2;
            if(check(mid)) l =mid;
            else r = mid-1;
        }
        System.out.println(r);
        sc.close();
    }

    public static boolean check(int mid){
        int res = 0;
        for(int i = 0;i<N;i++){
            res+=(h[i]/mid) * (w[i]/mid);
            if(res>=K){
                return true;
            }
        }
        return false;
    }
}
