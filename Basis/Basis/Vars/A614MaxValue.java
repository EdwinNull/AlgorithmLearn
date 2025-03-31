package Basis.Vars;

import java.util.Scanner;

public class A614MaxValue {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		int a,b,c,max,temp;
		a=scanner.nextInt();b=scanner.nextInt();c=scanner.nextInt();
		temp = (a+b+Math.abs(a-b))/2;
		max= (c+temp+Math.abs(c-temp))/2;
		System.out.printf("%d eh o maior",max);
		scanner.close();
	}

}
