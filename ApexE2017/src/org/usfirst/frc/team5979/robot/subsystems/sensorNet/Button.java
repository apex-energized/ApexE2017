package org.usfirst.frc.team5979.robot.subsystems.sensorNet;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Supports button inputs on the DIO.
 * 
 * @version 1.0
 * @author Liam Williams
 */
public class Button {
	DigitalInput input;
	boolean state;
	public Button(int port) {
		input = new DigitalInput(port);
	}
	
	/**
	 * @return Returns the state of the button or other figital input.
	 */
	public boolean getData() {
		refresh();
		return state;
	}

	/**
	 * Refreshes the stored values of the digital input.
	 */
	protected void refresh() {
		state = input.get();
	}
	
}