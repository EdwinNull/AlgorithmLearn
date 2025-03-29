package Stimulate_Enum;

import java.util.*;

public class A1229DateProblem2 {
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a = sc.useDelimiter("\\D+").nextInt();
        b = sc.useDelimiter("\\D+").nextInt();
        c = sc.useDelimiter("\\D+").nextInt();
        for(int date=19600101;date<=20591231;date++){
            int year = date/10000;
            int month = (date%10000)/100;
            int day = date%100;
            if(check_day(year, month, day)){
                if(year%100==a&&month==b&&day==c||
                   month==a&&day==b&&year%100==c||
                   day==a&&month==b&year%100==c){
                    System.out.printf("%d-%02d-%02d\n",year,month,day);
                   }
            }
        }
        sc.close();
    }

    public static boolean check_day(int year, int month, int day){
        if(month==0 || month>12){
            return false;
        }
        if(day==0) return false;
        if(month != 2){
            if(day > days[month-1]) return false;
        }
        else{
            int leap = (year%100!=0&&year%4==0)||year%400==0?1:0;
            if(day>28+leap) return false;
        }
        return true;
    }
}
