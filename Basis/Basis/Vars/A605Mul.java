package Basis.Vars;

import java.util.Scanner;

public class A605Mul {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a,b;
		a= scanner.nextInt();b=scanner.nextInt();
		long prod = a*b;
		System.out.printf("PROD = %d",prod);
		scanner.close();
	}
}
