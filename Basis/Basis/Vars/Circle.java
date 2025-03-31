package Basis.Vars;

import java.util.Scanner;

public class Circle {

	static double PI = 3.14159;
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		double R = scanner.nextDouble();
		double S = R*R*PI;
		System.out.printf("A=%.4f",S);
		scanner.close();
	}
}
