package Delivery_Return_Division;

import java.util.Scanner;

public class A795Prefix {
    static int N = 100000;
    static int  n,m;
    static int[] a = new int[N+1];
    static int[] b = new int[N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
            b[i] = b[i-1]+a[i];
        }
        while(m-->0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(b[r]-b[l-1]);
        }
        sc.close();
    }
}
