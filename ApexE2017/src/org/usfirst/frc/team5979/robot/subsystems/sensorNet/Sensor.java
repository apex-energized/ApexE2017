package org.usfirst.frc.team5979.robot.subsystems.sensorNet;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Sensor type superclass.
 * 
 * @version 1.0
 * @author Liam Williams
 */
public class Sensor {
	AnalogInput input;
	double rawData;
	double data = 0;
	public Sensor(int port) {
		input = new AnalogInput(port);
	}
	
	/**
	 * Returns the data variable. Override if you are doing anything
	 * else in the method.
	 * @return Returns processed data.
	 */
	public double getData() {
		refresh();
		return data;
	}
	
	/**
	 * Returns the rawData variable. Override if you are doing anything
	 * else in the method.
	 * @return
	 */
	public double getRaw() {
		refresh();
		return rawData;
	}
	
	/**
	 * Refreshes the data variables. Override to add your data processing.
	 */
	protected void refresh() {
		rawData = input.getValue();
		data = rawData;
	}
}
