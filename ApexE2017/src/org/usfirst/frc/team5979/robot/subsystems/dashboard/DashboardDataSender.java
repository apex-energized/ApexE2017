package org.usfirst.frc.team5979.robot.subsystems.dashboard;

public class DashboardDataSender {
	static PDPboard pdp = new PDPboard();

	static public void update() {
		pdp.periodic();
	}
}
