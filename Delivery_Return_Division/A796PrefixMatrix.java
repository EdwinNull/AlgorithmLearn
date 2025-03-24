package Delivery_Return_Division;

import java.util.Scanner;

public class A796PrefixMatrix {
    static int N  = 1005;
    static int n,m,q;
    static int[][] a = new int[N][N];
    static int[][] s = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        for(int i = 1;i<=n;i++){
            for(int j =1;j<=m;j++){
                a[i][j] = sc.nextInt();
                s[i][j] = s[i-1][j]+s[i][j-1]-s[i-1][j-1]+a[i][j];
            }
        }
        while(q-->0){
            int x1,y1,x2,y2;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            System.out.println(s[x2][y2]-s[x1-1][y2]-s[x2][y1-1]+s[x1-1][y1-1]);
        }
        sc.close();
    }
}
