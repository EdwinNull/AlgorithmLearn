package Basis.Vars;

import java.util.Scanner;

public class A612BallVolume {
	static double PI = 3.14159;
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int R = scanner.nextInt();
		double res = PI*R*R*R*4/3.0;
		System.out.printf("VOLUME = %.3f", res);
		scanner.close();
	}
}
