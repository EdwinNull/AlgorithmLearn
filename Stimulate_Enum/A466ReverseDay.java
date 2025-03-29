package Stimulate_Enum;

import java.util.*;

public class A466ReverseDay {
    static int months[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int date1 = sc.nextInt();
        int date2 = sc.nextInt();
        int res = 0;
        for(int i =1000;i<10000;i++){
            int date = i,x=i;
            for(int j = 0;j<4;j++){
                date = date*10+x%10;
                x/=10;
            }
            if(date1<=date&&date<=date2&&judge(date)){
                res++;
            }
        }
        System.out.println(res);
        sc.close();
    }
     
    public static boolean judge(int date){
        int year = date/10000;
        int month = (date%10000)/100;
        int day = date%100;
        if(month == 0 || month>12) return false;
        if(day==0 || (month != 2&&day>months[month])) return false;
        if(month == 2){
            int leap = (year%4==0&&year%100!=0) || year%400==0 ? 1 : 0;
            if(day>28+leap){
                return false;
            }
        }
        return true;
    }
}
