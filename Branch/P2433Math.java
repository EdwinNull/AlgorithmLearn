package Branch;

import java.util.Scanner;

public class P2433Math {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("I love Luogu!");
                break;
            }
            case 2: {
                System.out.println("6 4");
                break;
            }
            case 3: {
                System.out.println("3\n12\n2");
                break;
            }
            case 4: {
                double volume = 500.0 / 3;
                System.out.printf("%.3f", volume);
                break;
            }
            case 5: {
                System.out.println("15");
                break;
            }
            case 6: {
                double len = Math.sqrt(6 * 6 + 9 * 9);
                System.out.println(len);
                break;
            }
            case 7: {
                System.out.println("110\n90\n0\n");
                break;
            }
            case 8: {
                double pai = 3.141593;
                int r = 5;
                double lenth = 2 * pai * r;
                double s = 4 * pai * r * r;
                double v = (4 * pai * r * r * r) / 3;
                System.out.println(lenth);
                System.out.println(s);
                System.out.println(v);
                break;
            }
            case 9: {
                System.out.println("22");
                break;
            }
            case 10: {
                System.out.println("9");
                break;
            }
            case 11: {
                double res = 1.0 * 100 / 3;
                System.out.println(res);
                break;

            }
            case 12: {
                System.out.println("13\nR");
                break;

            }
            case 13: {
                double pi = 3.141593;
                double vol = (pi * 4 * 1.0 * (64 + 1000)) / 3;
                int a = (int) Math.pow(vol, 1.0 / 3);
                System.out.println(a);
                break;
            }
            case 14: {
                System.out.println("50");
                break;
            }
            default:
                System.out.println("no such number");
        }
        scanner.close();
    }
}
