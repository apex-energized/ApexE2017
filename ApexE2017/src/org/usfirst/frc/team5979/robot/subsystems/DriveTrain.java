package org.usfirst.frc.team5979.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem manages a drive train of 2 or 4 motors, and gives a handful of tools to work with them.
 * Work in Progress.
 * 
 * @version 0.1
 * @author Liam Williams
 */
public class DriveTrain extends Subsystem {
	RobotDrive robotDrive;
	
	/**
	 * Initializes the DriveTrain with two motors.
	 * @param motorL Motor on the left.
	 * @param motorR Motor on the right.
	 */
	public DriveTrain(int motorL, int motorR) {
		robotDrive = new RobotDrive(motorL, motorR);
		//TODO add log information
	}
	
	/**
	 * Initializes the DriveTrain with four motors.
	 * @param motorFL Motor on the front of the left side.
	 * @param motorBL Motor on the rear of the left side.
	 * @param motorFR Motor on the front of the right side.
	 * @param motorBR Motor on the rear of the right side.
	 */
	public DriveTrain(int motorFL, int motorBL, int motorFR, int motorBR) {
		robotDrive = new RobotDrive(motorFL, motorBL, motorFR, motorBR);
		//TODO add log information
	}
	
	/**
	 * Sets the motor speeds according to two values of -1 to 1 with 0 as a neutral point.]
	 * 1 is forward full speed and -1 is backwards full speed. Tank controls.
	 * @param stickL Left side control speed.
	 * @param stickR Right side control speed.
	 */
	public void tank(double stickL, double stickR) {
		robotDrive.tankDrive(stickL, stickR);
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
		
		//TODO add log information
		while(clock < duration) {
			robotDrive.drive(speed, turnRate);
			clock = System.currentTimeMillis();
		}
		
	}
	protected void initDefaultCommand() {	
	}

}
