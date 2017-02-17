package org.usfirst.frc.team5979.robot.subsystems;

/**
 * Class for aggregating information.
 * 
 * @version 1.0
 * @author Liam Williams
 */
public class Aggregator {
	public Aggregator() {
	}

	/**
	 * Combines two triggers into one speed double.
	 * @param low The trigger to be the lower half.
	 * @param high The trigger to be the upper half.
	 * @return The final combined speed.
	 */
	public double combineSpeed(double low, double high) {
		double toReturn = 0;
		toReturn += (low * 5);
		toReturn -= (high * 5);
		return toReturn;
	}
}
