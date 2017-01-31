package org.usfirst.frc.team5979.robot.subsystems.dashboard;

import org.usfirst.frc.team5979.robot.subsystems.sensorNet.PDP;
import org.usfirst.frc.team5979.robot.subsystems.sensorNet.Sensor;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PDPboard {
	String key1 = "PDP Temperature (C)";
	String key2 = "PDP Temperature (F)";
	String key3 = "PDP Voltage";
	String key4 = "PDP Current";
	double[] values;
	PDP pdp;
	public PDPboard() {
		pdp = new PDP();
	}

	public void periodic() {
		values = pdp.getAllReadings();
		sendData(key1, values[0]);
		sendData(key2, values[1]);
		sendData(key3, values[2]);
		sendData(key4, values[3]);
	}
	
	private void sendData(String key, double data) {
		SmartDashboard.putNumber(key, data);
	}
}
