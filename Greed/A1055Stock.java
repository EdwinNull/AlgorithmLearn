package Greed;

import java.util.*;

public class A1055Stock {
    static int N = 100010;
    static int n;
    static int[] a = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int sub[] = new int[n+1];
        for(int i = 1;i<=n;i++){
            a[i] = sc.nextInt();
        }
        for(int i =1;i<n;i++){
            sub[i] = a[i+1]-a[i];
        }
        int sum = 0;
        Arrays.sort(sub);
        for(int i:sub){
            if(i>0){
                sum+=i;
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
