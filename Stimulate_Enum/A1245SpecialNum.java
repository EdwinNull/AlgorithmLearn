package Stimulate_Enum;

import java.util.*;

public class A1245SpecialNum {
    static int N = 10001;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1;i<=n;i++){
            boolean isSpecial = false;
            String s = Integer.toString(i);
            for(int j:s.chars().toArray()){
                if(j == '2' || j=='0' || j == '1' || j == '9'){
                    isSpecial = true;
                    break;
                }
            }
            sum += isSpecial? i : 0;
        }
        System.out.println(sum);
        sc.close();
    }
}
