package org.usfirst.frc.team5979.robot.subsystems.driveTrain;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Handles tank-style controls for the drive train. Can be run
 * in two-motor or four-motor configuration.
 * 
 * @version 1.0
 * @author Liam Williams
 */
public class TankDrive extends DriveTrain {
	RobotDrive tankDrive;
	
	/**
	 * Initializes the tank-style DriveTrain with two motors.
	 * @param motorL Motor on the left.
	 * @param motorR Motor on the right.
	 */
	public TankDrive(int motorL, int motorR) {
		tankDrive = new RobotDrive(motorL, motorR);
		log.send("Two-motor tank drive initialized.");
	}
	
	/**
	 * Initializes the tank-style DriveTrain with four motors.
	 * @param motorFL Motor on the front of the left side.
	 * @param motorBL Motor on the rear of the left side.
	 * @param motorFR Motor on the front of the right side.
	 * @param motorBR Motor on the rear of the right side.
	 */
	public TankDrive(int motorFL, int motorBL, int motorFR, int motorBR) {
		tankDrive = new RobotDrive(motorFL, motorBL, motorFR, motorBR);
		log.send("Four-motor tank drive initialized.");
	}
	/**
	 * Sets the motor speeds according to two values of -1 to 1 with 0 as a neutral point.]
	 * 1 is forward full speed and -1 is backwards full speed. Tank controls.
	 * @param stickL Left side control speed.
	 * @param stickR Right side control speed.
	 */
	public void tank(double stickL, double stickR) {
		tankDrive.tankDrive(-stickL, -stickR);
	}
	/**
	 * Drives at a given speed and curvature for a given time.
	 * @param left Left side speed.
	 * @param right Right side speed.
	 * @param time Time (in milliseconds) for the robot to drive. Must be a long format variable.
	 */
	public void autoDrive(double left, double right, long time) {
		long clock = System.currentTimeMillis(), 
				duration = (System.currentTimeMillis()) + Long.valueOf(time);
		
		log.send("Automatic drive sequence started for " + time + " milliseconds.");
		while(clock < duration) {
			tankDrive.tankDrive(left, right);
			clock = System.currentTimeMillis();
		}
		log.send("Automatic drive sequence time expired.");
	}
}