package DoublePoint_BFS_Graph;

import java.util.Scanner;

public class A1224ExchangeBottleForce {
    static int N;
    static int[] bol = new int[100010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            bol[i] = sc.nextInt();
        }
        int ans = 0;
        for(int i = 1;i<=N;i++){
            if(bol[i]!=i){
                for (int j = i+1; j <= N; j++) {
                    if(bol[j]==i){
                        swap(bol,i,j);
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
