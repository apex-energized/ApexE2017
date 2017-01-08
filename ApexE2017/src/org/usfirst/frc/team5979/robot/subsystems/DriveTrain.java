package org.usfirst.frc.team5979.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem manages a drive train of 2 or 4 motors, and gives a handful of tools to work with them.
 * Supports tankDrive (declared with DriveTrain.tankDrive()) when creating the object.
 * Work in Progress.
 * 
 * @version 0.2
 * @author Liam Williams
 */
public class DriveTrain {
	
	/**
	 * Inner class handling tank-style drive specific functions.
	 */
	class tankDrive extends Subsystem {
		RobotDrive tankDrive;
		
		/**
		 * Initializes the tank-style DriveTrain with two motors.
		 * @param motorL Motor on the left.
		 * @param motorR Motor on the right.
		 */
		public tankDrive(int motorL, int motorR) {
			tankDrive = new RobotDrive(motorL, motorR);
			//TODO add log information
		}
		
		/**
		 * Initializes the tank-style DriveTrain with four motors.
		 * @param motorFL Motor on the front of the left side.
		 * @param motorBL Motor on the rear of the left side.
		 * @param motorFR Motor on the front of the right side.
		 * @param motorBR Motor on the rear of the right side.
		 */
		public tankDrive(int motorFL, int motorBL, int motorFR, int motorBR) {
			tankDrive = new RobotDrive(motorFL, motorBL, motorFR, motorBR);
			//TODO add log information
		}
		/**
		 * Sets the motor speeds according to two values of -1 to 1 with 0 as a neutral point.]
		 * 1 is forward full speed and -1 is backwards full speed. Tank controls.
		 * @param stickL Left side control speed.
		 * @param stickR Right side control speed.
		 */
		public void tank(double stickL, double stickR) {
			tankDrive.tankDrive(stickL, stickR);
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
				tankDrive.drive(speed, turnRate);
				clock = System.currentTimeMillis();
			}
		}
		public void initDefaultCommand() {}
	}
	/**
	 * Inner class handling arcade-style drive specific functions.
	 */
	class arcadeDrive extends Subsystem {
		RobotDrive arcadeDrive;
		/**
		 * Initializes the arcade-style DriveTrain with two motors.
		 * @param motorL Motor on the left.
		 * @param motorR Motor on the right.
		 */
		public arcadeDrive(int motorL, int motorR) {
			arcadeDrive = new RobotDrive(motorL, motorR);
			//TODO add log information
		}
		/**
		 * Initializes the arcade-style DriveTrain with four motors.
		 * @param motorFL Motor on the front of the left side.
		 * @param motorBL Motor on the rear of the left side.
		 * @param motorFR Motor on the front of the right side.
		 * @param motorBR Motor on the rear of the right side.
		 */
		public arcadeDrive(int motorFL, int motorBL, int motorFR, int motorBR) {
			arcadeDrive = new RobotDrive(motorFL, motorBL, motorFR, motorBR);
			//TODO add log information
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
			
			//TODO add log information
			while(clock < duration) {
				arcadeDrive.drive(speed, turnRate);
				clock = System.currentTimeMillis();
			}
		}
		public void initDefaultCommand() {}
	}

}
