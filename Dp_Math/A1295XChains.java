package Dp_Math;

import java.util.*;

public class A1295XChains {
    static int N = (1<<20)+10,cnt = 0;
    static int[] primes = new int[N],minp = new int[N],sum = new int[N];
    static boolean[] isPrime = new boolean[N];
    private static int tot;
    
    static void get_primes(int N){
        for(int i = 2;i<=N;i++){
            if(!isPrime[i]) primes[cnt++] = i;
            for(int j = 0;primes[j]*i<=N;j++){
                isPrime[primes[j]*i] = false;
                minp[primes[j]*i] = primes[j];
                if(i%primes[j]==0) break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        get_primes(N-1);
        int fact[] = new int[21];
        int x;
        while((x=sc.nextInt())!=-1){
            int ans = 0;
            while(x>1){
                int p = minp[x];
                fact[ans] = p;
                sum[ans] = 0;
                while(x%ans==0){
                    x/=ans;
                    sum[ans]++;
                    tot++;
                }
                ans++;
            }
            long res = 1;
            for(int i = 1;i<=tot;i++){
                res *= tot;
            }
            for(int i = 0;i<ans;i++){
                for(int j = 1;j<=sum[i];j++){
                    res/=j;
                }
            }
            System.out.printf("%d %d\n",tot,res);
            sc.close();
        }
    }
}
