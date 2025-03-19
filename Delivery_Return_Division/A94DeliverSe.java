package Delivery_Return_Division;

import java.util.Scanner;

public class A94DeliverSe {
    public static int MAXN = 10;
    public static int n;
    public static int[] arr = new int [MAXN];
    public static boolean[] user = new boolean[MAXN];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list(1);
        sc.close();
    }
    
    public static void list(int u) {
        if(u>n){
            //此时已经列举完所有可能，输出结果
            for(int i=1;i<=n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i<=n; i++){
            if(!user[i]){
                //做选择
                arr[u] = i;
                user[i] = true;
                list(u+1);

                arr[u] = 0;
                user[i] = false;
                //恢复现场，即回溯
            }
        }
    }
}
