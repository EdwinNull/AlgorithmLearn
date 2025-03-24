package Dp_Math;

import java.util.Scanner;

public class A1211AntCold {
    static int n;
    static int[] x = new int[100001];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            x[i] = sc.nextInt();
            }
        int left = 0,right = 0;
        for(int i = 1;i<n;i++){
            if(Math.abs(x[i])<Math.abs(x[0])&&x[i]>0){
                left++;
            }
            else if(Math.abs(x[i])>Math.abs(x[0])&&x[i]<0){
                right++;
            }
        }
        if(x[0]>0&&right==0 || x[0]<0&&left==0){
            System.out.println(1);
        }
        else{
            System.out.println(left+right+1);
        }
        sc.close();
    }
}
