package org.usfirst.frc.team5979.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

/**
 * Handles any sensor input and properly formats inputs into 
 * a ready-to-read format.
 * 
 * Currently only supports onboard PDP sensors.
 * @version 1.0
 * @author Liam Williams
 */
public class SensorNet {

	public SensorNet() {
	}

	/**
	 * Inner class specialized in handling PDP sensors.
	 */
	class PDP {
		double temp;
		double tempF;
		double voltage;
		double current;
		PowerDistributionPanel pdp = new PowerDistributionPanel();
		public PDP() {
			refresh();
		}
		
		/**
		 * Refreshes the data from the PDP sensors.
		 */
		private void refresh() {
			temp = pdp.getTemperature();
			tempF = convert(temp);
			voltage = pdp.getVoltage();
			current = pdp.getTotalCurrent();
		}
		
		/**
		 * Converts the PDP Celsius reading to Fahrenheit.
		 * @param C Celsius input.
		 * @return Fahrenheit output.
		 */
		private double convert(double C) {
			double F = 0;
			F = ((C * 9) / 5) + 32;
			return F;
		}
		
		/**
		 * Packages up the PDP readings to be sent out.
		 * [0] = Temperature (C)
		 * [1] = Voltage
		 * [2] = Current
		 * @return Readings from the PDP in an array.
		 */
		public double[] getAllReadings() {
			refresh();
			double[] toReturn = new double[2];
			toReturn[0] = temp;
			toReturn[1] = voltage;
			toReturn[2] = current;
			return toReturn;
		}
		
		/**
		 * Packages up the PDP readings to be sent out, with Fahrenheit
		 * temperature reading in addition.
		 * [0] = Temperature (C)
		 * [1] = Temperature (F)
		 * [2] = Voltage
		 * [3] = Current
		 * @return Readings from the PDP in an array.
		 */
		public double[] getAllReadingsF() {
			refresh();
			double[] toReturn = new double[3];
			toReturn[0] = temp;
			toReturn[1] = tempF;
			toReturn[2] = voltage;
			toReturn[3] = current;
			return toReturn;
		}
		
		/**
		 * @return Celsius temperature from PDP onboard sensor.
		 */
		public double getTemprature() {
			refresh();
			return temp;
		}
		
		/**
		 * @return Fahrenheit temperature from PDP onboard sensor.
		 */
		public double getTempratureF() {
			refresh();
			return tempF;
		}
		
		/**
		 * @return Voltage from PDP onboard sensor.
		 */
		public double getVoltage() {
			refresh();
			return voltage;
		}
		
		/**
		 * @return Overall current from PDP onboard sensors.
		 */
		public double getCurrent() {
			refresh();
			return current;
		}
	}
}
