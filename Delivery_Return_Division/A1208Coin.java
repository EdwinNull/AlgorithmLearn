package Delivery_Return_Division;

import java.util.Scanner;

public class A1208Coin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != t.charAt(i)) {
                flip(arr, i);
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }

    private static void flip(char[] arr, int i) {
        arr[i] = (arr[i] == '*') ? 'o' : '*';
        if (i + 1 < arr.length) {
            arr[i + 1] = (arr[i + 1] == '*') ? 'o' : '*';
        }
    }
}
