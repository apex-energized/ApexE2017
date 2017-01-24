package org.usfirst.frc.team5979.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

/**
 * Handles any sensor input and properly formats inputs into 
 * a ready-to-read format.
 * 
 * Currently only supports onboard PDP sensors.
 * @version 1.2
 * @author Liam Williams
 */
public class SensorNet {
	
	/**
	 * Inner class specializing in supporting sensors without SensorNet support.
	 */
	class unsigned extends sensorBase {
		AnalogInput input;
		double rawData;
		double data = 0;
		public unsigned(int port) {
			input = new AnalogInput(port);
		}
		
		/**
		 * unsigned sensor type does not know how to process data in a readable
		 * form, so the output will always be 0.
		 * @return 0
		 */
		public double getData() {
			return 0;
		}
		
		/**
		 * Gets the raw data from the port.
		 * @return Raw analog data from sensor.
		 */
		public double getRaw() {
			refresh();
			return rawData;
		}
		
		/**
		 * Refreshes the stored value from the sensor.
		 */
		protected void refresh() {
			rawData = input.getValue();
		}
	}

	/**
	 * Inner class for handling buttons or any other digital inputs.
	 */
	class button {
		DigitalInput input;
		boolean state;
		public button(int port) {
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

/**
 * Interface defining basic methods that should be common among all
 * sensor handlers.
 * 
 * @version 1.0
 * @author Liam Williams
 */
abstract class sensorBase {
	public abstract double getData();
	public abstract double getRaw();
	protected abstract void refresh();
}
