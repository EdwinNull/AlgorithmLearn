package Branch;

import java.util.Scanner;

public class P5712Apples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=1){
            System.out.printf("Today, I ate %d apple.",n);
        }
        else{
            System.out.printf("Today, I ate %d apples.",n);
        }
        sc.close();
    }
}
