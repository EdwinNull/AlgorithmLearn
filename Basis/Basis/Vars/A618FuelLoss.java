package Basis.Vars;

import java.util.Scanner;

public class A618FuelLoss {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		Long T = scanner.nextLong();
		Long S = scanner.nextLong();
		double L = (S*T)/12.0;
		System.out.printf("%.3f", L);
		scanner.close();
	}

}
