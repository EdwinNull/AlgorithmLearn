package Basis.Vars;

import java.util.Scanner;

public class GasLoss {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int X = scanner.nextInt();
		double Y = scanner.nextDouble();
		System.out.printf("%.3f km/l",X/Y);
		scanner.close();
	}
}
