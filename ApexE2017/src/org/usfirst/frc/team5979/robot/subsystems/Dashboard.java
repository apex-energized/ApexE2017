package org.usfirst.frc.team5979.robot.subsystems;

import org.usfirst.frc.team5979.robot.subsystems.SensorNet;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Handles SmartDashboard controllers and data being sent to and
 * from the dashboard including but not limited to sensor data 
 * and autonomous type selection.
 * 
 * @version 0.1
 * @author Liam Williams
 */
public class Dashboard {

	/*
	 * Inner class that will handle PDP readings sent to the dashboard
	 * without any flexibility.
	 */
	class pdpDefault {
		SensorNet s;
		SensorNet.PDP pdp;
		public pdpDefault() {
			pdp = s.new PDP();
		}
		
		/**
		 * Gets readings and sends them to the Dashboard.
		 */
		public void refresh() {
			SmartDashboard.putNumber("PDP Internal Temperature (C)", pdp.getTemprature());
			SmartDashboard.putNumber("PDP Internal Temperature (F)", pdp.getTempratureF());
			SmartDashboard.putNumber("PDP Voltage", pdp.getVoltage());
			SmartDashboard.putNumber("PDP Overall Current Draw", pdp.getCurrent());
		}
	}

}
