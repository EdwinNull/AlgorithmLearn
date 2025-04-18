package TreeArray_LineTree;

import java.io.*;

public class A1265CountStar {
    static int N = 32020;
    static int n;
    static int[] tr = new int[N+1];
    static int[] ans = new int[N+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        for(int i = 0;i<n;i++){
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            x++;
            ans[query(x)]++;
            add(x);
        }
        for(int i = 0;i<n;i++){
            bw.write(ans[i]+"\n");
        }
        bw.flush();
    }

    public static int lowbit(int x){
        return x&-x;
    }

    public static void add(int x){
        for(int i = x;i<=N;i+=lowbit(i)){
            tr[i] ++;
        }
    }

    public static int query(int x){
        int res = 0;
        for(int i = x;i>0;i-=lowbit(i)){
            res += tr[i];
        }
        return res;
    }
}
