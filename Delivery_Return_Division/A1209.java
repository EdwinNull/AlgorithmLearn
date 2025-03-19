package Delivery_Return_Division;

import java.util.*;

public class A1209 {
    static int n;
    static boolean[] st = new boolean[10]; // 数字使用标记
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs_a(0, 0);
        System.out.println(ans);
        sc.close();
    }

    // 枚举a的每一位
    static void dfs_a(int u, int a) {
        if (a >= n || u >= 7)
            return; // a不能超过n
        if (a > 0)
            dfs_c(u, a, 0); // 如果a有值，开始枚举c

        for (int i = 1; i <= 9; i++) {
            if (!st[i]) {
                st[i] = true;
                dfs_a(u + 1, a * 10 + i);
                st[i] = false;
            }
        }
    }

    // 枚举c的每一位
    static void dfs_c(int u, int a, int c) {
        if (u >= 9)
            return;

        if (check(a, c))
            ans++; // 验证成功后计数

        for (int i = 1; i <= 9; i++) {
            if (!st[i]) {
                st[i] = true;
                dfs_c(u + 1, a, c * 10 + i);
                st[i] = false;
            }
        }
    }

    // 验证b是否合法
    static boolean check(int a, int c) {
        long b = (long) c * (n - a);
        if (b <= 0)
            return false;

        boolean[] backup = st.clone();
        // 检查b的每一位
        while (b > 0) {
            int x = (int) (b % 10);
            b /= 10;
            if (x == 0 || backup[x])
                return false;
            backup[x] = true;
        }
        // 检查所有数字是否用完
        for (int i = 1; i <= 9; i++) {
            if (!backup[i])
                return false;
        }
        return true;
    }
}
