package Delivery_Return_Division;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A1221Four {
    static int N;

    static class Sum {
        int s, c, d;

        public Sum(int s, int c, int d) {
            this.s = s;
            this.c = c;
            this.d = d;
        }
    }


    @SuppressWarnings("rawtypes")
    static List<Sum> list = new ArrayList();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            for (int c = 0; c * c <= N; c++) {
                for (int d = 0; d * d <= N - c * c; d++) {
                    list.add(new Sum(d * d + c * c, c, d));
                }
            }
            // 字典序排序 lambda表达式
            list.sort((sum1, sum2) -> {
                if (sum1.s != sum2.s)
                    return sum1.s - sum2.s;
                if (sum1.c != sum2.c)
                    return sum1.c - sum2.c;
                return sum1.d - sum2.d;
            });
            // 遍历前两个数
            for (int a = 0; a * a <= N; a++) {
                for (int b = a; b * b <= N - a * a; b++) {
                    int x = N - a * a - b * b;
                    int l = 0, r = list.size() - 1;
                    while (l < r) {
                        int mid = (l + r) / 2;
                        if (list.get(mid).s >= x)
                            r = mid;
                        else
                            l = mid + 1;
                    }
                    if (list.get(l).s == x) {
                        int c = list.get(l).c;
                        int d = list.get(l).d;
                        System.out.println(a + " " + b + " " + c + " " + d);
                        return;
                    }
                }
            }
            sc.close();
        }
    }
}


