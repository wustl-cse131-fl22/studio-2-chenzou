package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the times of simulation: ");
		int simulationTimes = in.nextInt();
		
		int pointInTarget = 0;
		
		for (int i = 0; i < simulationTimes; i++) {
			double xPoint = Math.random();
			double yPoint = Math.random();
			double dist = Math.sqrt(xPoint*xPoint + yPoint*yPoint);
			
			if (dist < 1) {
				pointInTarget++;
			}
		}
		
		double piCalculated = 4 * ( (double) pointInTarget/simulationTimes);
		System.out.println("The value of pi: " + piCalculated);

	}

}
