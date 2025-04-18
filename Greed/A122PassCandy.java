package Greed;

import java.io.*;
import java.util.*;

public class A122PassCandy {
    static int N = 1000010;
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    public static void main(String[] args) throws Exception {
        int n = nextInt();
        long[] a = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            sum += a[i];
        }
        long ave = sum / n;
        a[n - 1] = ave - a[n - 1];
        for (int i = n - 2; i > 0; i--)
            a[i] = ave + a[i + 1] - a[i];

        a[0] = 0;
        Arrays.sort(a);
        long res = 0;
        for (int i = 0; i < n; i++)
            res += Math.abs(a[i] - a[n / 2]);
        out.print(res);
        out.close();
    }
}
