package Loop;

import java.util.Scanner;

public class LSquareSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputA = scanner.nextLine();
        String inputB = scanner.nextLine();
        String absA = getAbsoluteValue(inputA);
        absA = removeLeadingZeros(absA);
        String absB = getAbsoluteValue(inputB);
        absB = removeLeadingZeros(absB);
        String aSquared = multiply(absA, absA);
        String bSquared = multiply(absB, absB);
        int cmp = compare(aSquared, bSquared);
        String result;
        if (cmp > 0) {
            result = subtract(aSquared, bSquared);
        } else if (cmp < 0) {
            result = "-" + subtract(bSquared, aSquared);
        } else {
            result = "0";
        }
        System.out.println(result);
        scanner.close();
    }

    private static String getAbsoluteValue(String num) {
        return num.startsWith("-") ? num.substring(1) : num;
    }

    private static String removeLeadingZeros(String num) {
        int start = 0;
        while (start < num.length() && num.charAt(start) == '0') {
            start++;
        }
        if (start == num.length()) {
            return "0";
        }
        return num.substring(start);
    }

    private static int compare(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return 1;
        } else if (num1.length() < num2.length()) {
            return -1;
        } else {
            for (int i = 0; i < num1.length(); i++) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(i) - '0';
                if (n1 > n2) {
                    return 1;
                } else if (n1 < n2) {
                    return -1;
                }
            }
            return 0;
        }
    }

    private static String subtract(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int borrow = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0) {
            int n1 = (num1.charAt(i--) - '0') - borrow;
            int n2 = j >= 0 ? (num2.charAt(j--) - '0') : 0;
            if (n1 < n2) {
                n1 += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            res.append(n1 - n2);
        }
        String result = res.reverse().toString();
        result = removeLeadingZeros(result);
        return result.isEmpty() ? "0" : result;
    }

    private static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = x * y + pos[i + j + 1];
                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int p : pos) {
            if (!(res.length() == 0 && p == 0)) {
                res.append(p);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
