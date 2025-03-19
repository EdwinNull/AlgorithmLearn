package Delivery_Return_Division;

import java.util.Scanner;

public class A94DeliverList {
    public static int MAXN = 16;
    public static int n;
    public static int[] arr = new int[MAXN];
    public static int[][] ways =new int[1<<15][16];
    public static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        generate(1);
        for(int i = 0;i<cnt;i++){
            for(int j = 1;j<=n;j++){
                System.out.printf("%d ",ways[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }

    public static void generate(int u){
        if(u>n){
            for(int i = 1;i<=n;i++){
                if (arr[i] == 1) {
                    ways[cnt][i] = i;
                }
            }
            for(int i = 1;i<=n;i++){
                if(arr[i]==1){
                    System.out.printf("%d ",i);
                }
            }
            cnt++;
            System.out.println();
            return;
        }
        arr[u] = 2;
        generate(u+1);
        arr[u] = 0;

        arr[u] = 1;
        generate(u+1);
        arr[u] = 0;
    }
}
