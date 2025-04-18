package Greed;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

class Segment implements Comparable<Segment> {
    // 区间[a,b]
    double a, b;

    public Segment(double aa, double bb) {
        a = aa;
        b = bb;
    }

    public int compareTo(Segment o) {
        return Double.compare(this.b, o.b);
    }
}

public class A112Radar {
    static int N = 1010;
    static double INF = 10e8;
    static double esp = 10e-6;
    static Segment seg[] = new Segment[N];

    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt(), d = reader.nextInt();
        boolean success = true;
        for(int i = 0; i < n; i++)
        {
            int x = reader.nextInt(), y = reader.nextInt();
            if( Math.abs(y) > d )
            {
                success = false;
                break;
            }
            //
            double len = Math.sqrt(d * d - y * y);
            seg[i] = new Segment(x - len, x + len);
        }


        if( ! success)
            System.out.println( - 1);
        else{
            Arrays.sort(seg, 0, n);
            double  last = - INF;
            int res = 0;
            for(int i = 0; i < n; i++)
            {
                if(seg[i].a -last > esp)
                {
                    res ++;
                    last = seg[i].b;
                }

            }
            System.out.println(res);
        }
        reader.close();
    }
}
