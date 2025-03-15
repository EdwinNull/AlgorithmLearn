package Loop;

import java.util.Arrays;
import java.util.Scanner;

public class P1009FactorialSum {
    static final int MAXN = 1000;
    static int[] ans = new int[MAXN + 1];
    static int[] facto = new int[MAXN + 1];
    static int[] ans_ = new int[MAXN + 1];
    static int[] facto_ = new int[MAXN + 1];
    static int[] k_ = new int[MAXN + 1];

    static void mul(int k) {
        Arrays.fill(facto_, 0);
        Arrays.fill(k_, 0);
        
        // 分解k到k_数组（逆序存储）
        int len = 0;
        while (k > 0) {
            k_[++len] = k % 10;
            k /= 10;
        }
        k_[0] = len; // k_[0]存储位数

        // 高精度乘法
        for (int i = 1; i <= k_[0]; i++) {
            int carry = 0;
            for (int j = 1; j <= facto[0]; j++) {
                int temp = facto_[i + j - 1] + k_[i] * facto[j] + carry;
                facto_[i + j - 1] = temp % 10;
                carry = temp / 10;
            }
            facto_[i + facto[0]] = carry;
        }

        // 计算结果位数并更新facto
        facto_[0] = facto[0] + k_[0];
        while (facto_[0] > 0 && facto_[facto_[0]] == 0) {
            facto_[0]--;
        }
        System.arraycopy(facto_, 0, facto, 0, facto_[0] + 1);
    }

    static void add() {
        Arrays.fill(ans_, 0);
        
        // 高精度加法
        int maxLen = Math.max(ans[0], facto[0]);
        int carry = 0;
        for (int i = 1; i <= maxLen; i++) {
            int sum = ans[i] + facto[i] + carry;
            ans_[i] = sum % 10;
            carry = sum / 10;
            ans_[0] = i;
        }
        if (carry > 0) {
            ans_[++ans_[0]] = carry;
        }
        System.arraycopy(ans_, 0, ans, 0, ans_[0] + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(facto, 0);
            facto[0] = 1; // 位数
            facto[1] = 1; // 初始值1!

            for (int j = 1; j <= i; j++) {
                mul(j);
            }
            add();
        }

        for (int i = ans[0]; i >= 1; i--) {
            System.out.print(ans[i]);
        }
        System.out.println();
    }
}
