package Dp_Math;

import java.util.*;

public class A1047Candy {
    static int MAXN = 1010;
    static int N,K;
    static int[] candy = new int[MAXN];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        for(int i=1;i<=N;i++){
            candy[i] = sc.nextInt();
        }
        sc.close();
    }
}
