package Branch;

import java.util.Scanner;

public class P5717Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (b > c) {
            temp = b;
            b = c;
            c = temp;
        }
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        judgeTriangle(a, b, c);
    }

    public static void judgeTriangle(int a, int b, int c) {
        if(a+b <= c){
            System.out.println("Not triangle");
            return;
        }
        else if(a == b && b == c){
            System.out.println("Acute triangle");
            System.out.println("Isosceles triangle");
            System.out.println("Equilateral triangle");
        }
        else if(a*a + b*b > c*c){
            if(a == b){
                System.out.println("Acute triangle");
                System.out.println("Isosceles triangle");
            }
            else{
                System.out.println("Acute triangle");
            }
        }
        else if(a*a + b*b < c*c){
            if(a == b){
                System.out.println("Obtuse triangle");
                System.out.println("Isosceles triangle");
            }
            else{
                System.out.println("Obtuse triangle");
            }
        }
        else{
            if(a == b){
                System.out.println("Right triangle");
                System.out.println("Isosceles triangle");
            }
            else{
                System.out.println("Right triangle");
            }
        }
    }
}
