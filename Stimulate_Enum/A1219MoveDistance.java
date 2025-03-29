package Stimulate_Enum;

import java.util.Scanner;

public class A1219MoveDistance {
    static int w, m, n, x[] = new int[10005], y[] = new int[10005], r, c = 1, t = -1;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();
        m --;n--;
        int x1 = m/w;int x2 = n/w;
        int y1 = m%w;int y2 = n%w;
        if((x1&1)==1){
            y1= w-1-y1;
        }
        if((x2&1)==1) y2= w-1-y2;
        System.out.println(Math.abs(x1-x2)+Math.abs(y1-y2));
        sc.close();
    }
}
