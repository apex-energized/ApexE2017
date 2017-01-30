package org.usfirst.frc.team5979.robot.subsystems.driveTrain;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Handles arcade-style controls for the drive train. Can be run
 * in two-motor or four-motor configuration.
 * 
 * @version 0.1
 * @author Liam Williams
 */
public class ArcadeDrive extends DriveTrain {
	RobotDrive arcadeDrive;
	
	/**
	 * Initializes the arcade-style DriveTrain with two motors.
	 * @param motorL Motor on the left.
	 * @param motorR Motor on the right.
	 */
	public ArcadeDrive(int motorL, int motorR) {
		arcadeDrive = new RobotDrive(motorL, motorR);
		log.send("Two-motor arcade drive initialized.");
	}
	/**
	 * Initializes the arcade-style DriveTrain with four motors.
	 * @param motorFL Motor on the front of the left side.
	 * @param motorBL Motor on the rear of the left side.
	 * @param motorFR Motor on the front of the right side.
	 * @param motorBR Motor on the rear of the right side.
	 */
	public ArcadeDrive(int motorFL, int motorBL, int motorFR, int motorBR) {
		arcadeDrive = new RobotDrive(motorFL, motorBL, motorFR, motorBR);
		log.send("Four-motor arcade drive initialized.");
	}
	/**
	 * Sets the motor speeds based on the X and Y values of a single joystick.
	 * (Still capable of turning while not moving forward, FYI.)
	 * @param speed Foward/Backward speed in a range of -1 to 1. -1 is full reverse, 0 is neutral, 1 is full forward.
	 * @param turnRate Left/Right turn speed in a range of -1 to 1. -1 is full left, 0 is neutral, 1 is full right.
	 */
	public void arcade (double speed, double turnRate) {
		arcadeDrive.arcadeDrive(speed, turnRate);
	}
	/**
	 * Drives at a given speed and curvature for a given time.
	 * @param speed Speed between -1 and 1 to drive at. 1 is full forward, -1 is full backward, 0 is neutral.
	 * @param turnRate Rate of turn between -1 and 1. 1 is full right, -1 is full left, 0 is straight.
	 * @param time Time (in milliseconds) for the robot to drive. Must be a long format variable.
	 */
	public void autoDrive(double speed, double turnRate, long time) {
		long clock = System.currentTimeMillis(), 
				duration = (System.currentTimeMillis()) + Long.valueOf(8000);
		
		log.send("Automatic drive sequence started for " + time + " milliseconds.");
		while(clock < duration) {
			arcadeDrive.drive(speed, turnRate);
			clock = System.currentTimeMillis();
		}
		log.send("Automatic drive sequence time expired.");
	}
}