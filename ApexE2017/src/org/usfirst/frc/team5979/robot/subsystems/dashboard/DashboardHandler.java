package org.usfirst.frc.team5979.robot.subsystems.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Superclass for handling SmartDashboard interactions.
 * 
 * @version 1.0
 * @author Liam Williams
 */
public class DashboardHandler {
	String key;
	public DashboardHandler(String key) {
		this.key = key;
	}

	/**
	 * Sends a number value to the dashboard.
	 * @param value Number to be sent (double).
	 */
	public void sendValue(double value) {
		SmartDashboard.putNumber(key, value);
	}
	
	/**
	 * Sends a String to the dashboard.
	 * @param value String to be sent.
	 */
	public void sendString(String value) {
		SmartDashboard.putString(key, value);
	}
	
	/**
	 * Recieves a String from the dashboard.
	 * @return String recieved.
	 */
	public String recieveEntry() {
		return SmartDashboard.getString(key, null);
	}
	
	/**
	 * Recieves a number from the dashboard.
	 * @return Double recieved.
	 */
	public double recieveNumber() {
		return SmartDashboard.getNumber(key, -1);
	}
}
