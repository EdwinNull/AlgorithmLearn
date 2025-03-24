package Dp_Math;

import java.util.Scanner;

public class A1205NumNoBuy {
    static int p,q;
    public static void main(String[] args) {
        Scanner sc  = new Scanner (System.in);
        int res = 0;
        p = sc.nextInt();
        q = sc.nextInt();
        res = p*q - p - q;
        System.out.println(res);
        sc.close();  
    }
}
