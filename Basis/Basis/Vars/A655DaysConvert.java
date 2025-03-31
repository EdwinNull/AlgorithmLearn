package Basis.Vars;

import java.util.Scanner;

public class A655DaysConvert {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		double N = scanner.nextDouble();
		//这里可能会有浮点jdu4问题，因此将元转换为100分来进行计算，避免浮点计算
        int totalCents = (int) Math.round(N * 100);
        int[] notes = {10000, 5000, 2000, 1000, 500, 200};
        int[] coins = {100, 50, 25, 10, 5, 1};

        System.out.println("NOTAS:");
        for (int note : notes) {
            int count = totalCents / note;
            totalCents %= note;
            System.out.printf("%d nota(s) de R$ %.2f\n", count, note / 100.0);
        }
        System.out.println("MOEDAS:");
        for (int coin : coins) {
            int count = totalCents / coin;
            totalCents %= coin;
            System.out.printf("%d moeda(s) de R$ %.2f\n", count, coin / 100.0);
        }
		scanner.close();
	}

}
