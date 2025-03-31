package Basis.Vars;

import java.util.Scanner;

public class Cash {
	static int N;
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		int a = 0,b=0,c=0,d=0,e=0,f=0,g=0;
		System.out.println(N);
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
				g++;
				N-=1;
			}
		System.out.printf("%d nota(s) de R$ 100,00\n",a);
		System.out.printf("%d nota(s) de R$ 50,00\n",b);
		System.out.printf("%d nota(s) de R$ 20,00\n",c);
		System.out.printf("%d nota(s) de R$ 10,00\n",d);
		System.out.printf("%d nota(s) de R$ 5,00\n",e);
		System.out.printf("%d nota(s) de R$ 2,00\n",f);
		System.out.printf("%d nota(s) de R$ 1,00\n",g);
		scanner.close();
	}
}
