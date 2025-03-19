package Branch;

import java.util.Scanner;

public class P5716MonthDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int days = 0;
        days = getDays(year, month);
        System.out.println(days);
        sc.close();
    }

    public static int getDays(int year, int month){
        if(year%4==0 && (year%100!=0 || year%400==0)){
            if(month==2){
                return 29;
            }else if(month==4 || month==6 || month==9 || month==11){
                return 30;
            }else{
                return 31;
            }
        }else{
            if(month==2){
                return 28;
            }else if(month==4 || month==6 || month==9 || month==11){
                return 30;
            }else{
                return 31;
            }
        }
    }
}
