package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Start Amount");
		double startAmount = in.nextDouble();
		System.out.println("Win Chance");
		double winChance = in.nextDouble();
		System.out.println("Win Limit");
		double winLimit = in.nextDouble();
		System.out.println("Total Simulations");
		double totalSimulations = in.nextDouble();
		int ruinNo = 0;

		for (int i = 0; i < totalSimulations; i++) {
			double dayStartingAmount = startAmount;
			int playsToday = 0;
			while (dayStartingAmount > 0 && dayStartingAmount < winLimit) {
				double x = Math.random();

				if (x < winChance) {
					dayStartingAmount += 1;
					playsToday += 1;
				} else {
					dayStartingAmount -= 1;
					playsToday += 1;

				}
			}
			System.out.println("Day Number: " + i);
			System.out.println("Plays Today:" + playsToday);
			if (dayStartingAmount == 0) {
				System.out.println("Ruin");
				ruinNo += 1;
			}
			else {
				System.out.println("Success");
			}
		}	

		System.out.println("Total Simulations:" + totalSimulations);
		double ruinRate = ruinNo * 100.0 / totalSimulations;
		System.out.println("Ruin Rate: " + ruinRate + "%");
		
		if(winChance == 0.5) {
			double expectedRuin = 1-startAmount/winLimit;
			System.out.println("Expected Ruin Rate: " + expectedRuin);
		}
		else {
			double a = (1 - winChance)/winChance;
			double expectedRuin = (Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a,winLimit));
			System.out.println("Expected Ruin Rate: " + expectedRuin);
		}
		
	}

}
