package Basis.Vars;

import java.util.Scanner;

public class Sub {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		int A,B,C,D;
		A = scanner.nextInt();B = scanner.nextInt();C = scanner.nextInt();D = scanner.nextInt();
		System.out.printf("DIFERENCA = %d",(A*B-C*D));
		scanner.close();
	}
}
