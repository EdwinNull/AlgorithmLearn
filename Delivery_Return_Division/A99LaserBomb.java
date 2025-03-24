package Delivery_Return_Division;

import java.util.Scanner;

public class A99LaserBomb {
    static int MAX = 5010;
    static int N,R,M;
    static int[][] s = new int[MAX][MAX];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        R = sc.nextInt();
        R = Math.min(5001,R);
        N = M = R;
        while(cnt -- > 0){
            int x,y,w;
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            x++; y++;
            N = Math.max(N,x);
            M = Math.max(M,y);
            s[x][y] += w;
        }

        for(int  i = 1;i <= N;i++){
            for(int j = 1;j <= M;j++){
                s[i][j] += s[i-1][j] + s[i][j-1] - s[i-1][j-1];
            }
        }
        int ans = 0;
        for(int  i =R;i <= N;i++){
            for(int j =R;j <= M;j++){
                ans = Math.max(ans,s[i][j] - s[i-R][j] - s[i][j-R] + s[i-R][j-R]);
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
