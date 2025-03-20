package Delivery_Return_Division;

import java.util.Scanner;

public class A790Root {
    static double n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextDouble();
        double l = -10000.0,r = 10000.0;
        while(r-l > 1e-8){
            double mid = (l+r)/2; 
            if(mid*mid*mid>=n){
                r=mid;
            }
            else{
                l=mid;
            }
        }
        System.out.printf("%.6f", l);
        sc.close();
    }
}
