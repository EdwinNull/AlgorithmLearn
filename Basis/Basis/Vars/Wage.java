package Basis.Vars;

import java.util.Scanner;

public class Wage {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		int ID = scanner.nextInt();
		int hour = scanner.nextInt();
		double w = scanner.nextDouble();
		System.out.printf("NUMBER = %d\n",ID);
		System.out.printf("SALARY = U$ %.2f",hour*w);
		scanner.close();
	}

}
