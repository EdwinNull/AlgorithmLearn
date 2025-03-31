package Basis.Vars;

import java.util.Scanner;

public class A656CashAndCoin {
	static double N;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextDouble();
		int a = 0,b=0,c=0,d=0,e=0,f=0;
		double a2=0,b2=0,c2=0,d2=0,e2=0,f2=0;
			while(N-100>=0) {
				a ++;
				N -= 100;
			}
			while(N-50>=0) {
				b ++;
				N -= 50;
			}
			while(N-20>=0) {
				c++;
				N-=20;
			}
			while(N-10>=0) {
				d++;
				N-=10;
			}
			while(N-5>=0) {
				e++;
				N-=5;
			}
			while(N-2>=0) {
				f++;
				N-=2;
			}
			while(N-1>=0) {
				a2 ++;
				N -= 1;
			}
			while(N-0.50>=0) {
				b2 ++;
				N -= 0.50;
			}
			while(N-0.25>=0) {
				c2++;
				N-=0.25;
			}
			while(N-0.10>=0) {
				d2++;
				N-=0.10;
			}
			while(N-0.05>=0) {
				e2++;
				N-=0.05;
			}
			while(N-0.01>=0) {
				f2++;
				N-=0.01;
			}
		System.out.println("NOTAS:");
		System.out.printf("%d nota(s) de R$ 100.00\n",a);
		System.out.printf("%d nota(s) de R$ 50.00\n",b);
		System.out.printf("%d nota(s) de R$ 20.00\n",c);
		System.out.printf("%d nota(s) de R$ 10.00\n",d);
		System.out.printf("%d nota(s) de R$ 5.00\n",e);
		System.out.printf("%d nota(s) de R$ 2.00\n",f);
		System.out.println("MOEDAS:");
		System.out.printf("%.0f moeda(s) de R$ 1.00\n",a2);
		System.out.printf("%.0f moeda(s) de R$ 0.50\n",b2);
		System.out.printf("%.0f moeda(s) de R$ 0.25\n",c2);
		System.out.printf("%.0f moeda(s) de R$ 0.10\n",d2);
		System.out.printf("%.0f moeda(s) de R$ 0.05\n",e2);
		System.out.printf("%.0f moeda(s) de R$ 0.01\n",f2);
		scanner.close();
	}

}
