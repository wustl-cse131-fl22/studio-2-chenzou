package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your start amount: ");
		int startAmount = in.nextInt();
		System.out.println("Enter the win chance: ");
		double winChance = in.nextDouble();
		System.out.println("Enter your win limit: ");
		double winLimit = in.nextDouble();
		System.out.println("Enter the number of total Simulations: ");
		int totalSimulations = in.nextInt();
		int Losses = 0;

		int currentAmount = startAmount;

		for (int i = 1; i <= totalSimulations; i++) {
			int gambleTimes = 0;

			while (currentAmount > 0 && currentAmount < winLimit){
				double rdn = Math.random();
				if (rdn <= winChance) {
					currentAmount ++;
				} else {
					currentAmount --;
				}
				gambleTimes ++;
			}

			if (currentAmount == 0) {
				System.out.println("Simulation " + i + ": " + gambleTimes + " LOSE");
				Losses ++;
			} else {
				System.out.println("Simulation " + i + ": " + gambleTimes + " WIN");
			}
			
			
			currentAmount = startAmount;
		}
		
		System.out.print("Losses: " + Losses + " ");
		System.out.println("Simulaitons: " + totalSimulations);
		System.out.print("Ruin Rate from Simulation: " + (double)Losses/totalSimulations);
		
		double expectedRuin;
		
		if (winChance == 0.5) {
			expectedRuin = 1 - (double) startAmount/winLimit;
		} else {
			double alpha = (1-winChance) / winChance;
			expectedRuin = ((Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1-Math.pow(alpha,winLimit)));
		}
		
		System.out.println(" Expected Ruin Rate: " + expectedRuin);
	}

}
