package Stimulate_Enum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1231Flight {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    static int get_seconds(int h, int m, int s)
    {
        return h * 3600 + m * 60 + s;
    }

    static int get_time() throws IOException 
    {
        String[] line = br.readLine().split(":| "); 

        int d = 0;
        if (line.length == 7) d = line[6].charAt(2)-'0';

        int h1 = Integer.parseInt(line[0]);
        int m1 = Integer.parseInt(line[1]);
        int s1 = Integer.parseInt(line[2]);
        int h2 = Integer.parseInt(line[3]);
        int m2 = Integer.parseInt(line[4]);
        int s2 = Integer.parseInt(line[5]);

        return get_seconds(h2, m2, s2) - get_seconds(h1, m1, s1) + d * 24 * 3600;
    }

    public static void main(String[] args) throws IOException {

        String[] input=br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);

        while (n -- >0)
        {
            int time = (get_time() + get_time()) / 2;
            int hour = time / 3600, minute = time % 3600 / 60, second = time % 60;
            System.out.println(String.format("%02d", hour)+":"+String.format("%02d", minute)+":"+String.format("%02d", second));
        }

    }
}
