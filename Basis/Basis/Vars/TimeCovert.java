package Basis.Vars;

import java.util.Scanner;

public class TimeCovert {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int hour=0,minute=0,sec=0;
		hour = N/3600;
		minute = (N%3600)/60;
		sec = (N%3600)%60;
		System.out.printf("%d:%d:%d",hour,minute,sec);
		scanner.close();
	}

}
