package Greed;

import java.util.*;

public class A104FareHouse {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] house = new int[n];
        for(int i = 0;i<n;i++){
            house[i] = sc.nextInt();
        }
        Arrays.sort(house);
        int mid = house[n/2];
        long res = 0;
        for(int i = 0;i<n;i++){
            res += Math.abs(house[i]-mid);
        }
        System.out.println(res);
        sc.close();   
    }
}
