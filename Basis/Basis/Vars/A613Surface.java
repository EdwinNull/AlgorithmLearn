package Basis.Vars;

import java.util.Scanner;

public class A613Surface {
	static double PI = 3.14159;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		double A,B,C;
		A =scanner.nextDouble();B=scanner.nextDouble();C=scanner.nextDouble();
		System.out.printf("TRIANGULO: %.3f\n", A*C/2);
		System.out.printf("CIRCULO: %.3f\n", PI*C*C);
		System.out.printf("TRAPEZIO: %.3f\n", (A+B)*C/2);
		System.out.printf("QUADRADO: %.3f\n", B*B);
		System.out.printf("RETANGULO: %.3f\n", A*B);
		scanner.close();
	}

}
