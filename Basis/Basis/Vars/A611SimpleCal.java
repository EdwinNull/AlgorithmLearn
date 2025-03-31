package Basis.Vars;

import java.util.Scanner;

public class A611SimpleCal {

	@SuppressWarnings("unused")
    public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		int num1,num2,q1,q2;
		double price1,price2,sum;
		num1 = scanner.nextInt();q1=scanner.nextInt();price1=scanner.nextDouble();
		num2 = scanner.nextInt();q2=scanner.nextInt();price2=scanner.nextDouble();
		sum = q1*price1+q2*price2;
		System.out.printf("VALOR A PAGAR: R$ %.2f",sum);
		scanner.close();
	}

}
