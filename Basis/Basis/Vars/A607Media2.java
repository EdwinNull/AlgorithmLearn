package Basis.Vars;

import java.util.Scanner;

public class A607Media2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		double A,B,C;
		A=scanner.nextDouble();B=scanner.nextDouble();C=scanner.nextDouble();
		System.out.printf("MEDIA = %.1f", (A*2+B*3+C*5)/10);
		scanner.close();
	}

}
