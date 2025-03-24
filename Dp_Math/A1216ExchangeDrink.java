package Dp_Math;

import java.util.Scanner;

public class A1216ExchangeDrink {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int res = n;
        int get = 0;
        while(n>=3){
            get = n/3;
            n -= get*3;
            res += get;
            n += get;
            get = 0;
        }
        System.out.println(res);
        sc.close();
    }
}
