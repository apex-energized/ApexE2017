package org.usfirst.frc.team5979.robot.subsystems;

import java.util.ArrayList;
import java.util.List;
import edu.wpi.first.wpilibj.Victor;

/**
 * Controls Victor 888, 884, and SPARK motor controllers.
 * Capable of slaving together multiple motors to be controlled all at once.
 * Capable of running a timed sequence.
 * Work in Progress.
 * 
 * @version 0.1.3
 * @author Liam Williams
 */
public class MotorController {
	SerialController log = new SerialController("MXP");
	List<Integer> ports = new ArrayList<Integer>();
	List<Victor> motorArray;
	Victor motor;
	
	/**
	 * Initializes a Victor or SPARK controller on a given port.
	 * @param port PWM port containing the Victor.
	 */
	public MotorController(int port) {
		motorArray = new ArrayList<Victor>();
		motorArray.add(motor = new Victor(port));
		log.send("Initialized motor on port " + port);
		ports.add(port);
	}
	
	/**
	 * Slaves an additional (initialized by this method) Victor or SPARK to the current
	 * motorset contained in this object.
	 * @param port PWN port containing the Victor.
	 * @param reversed If the motor direction needs to be reversed.
	 */
	public void addSlave(int port, boolean reversed) {
		motorArray.add(motor = new Victor(port));
		if (reversed == true) {
			motorArray.get(motorArray.size()-1).setInverted(true);
		}
		log.send("Initialized slave motor on port " + port + " to " + ports.get(0) + "'s motor group.");
		ports.add(port);
	}
	
	/**
	 * Assigns a speed to the motor, forward or backwards.
	 * @param speed Speed from -1 to 1. -1 is full CCW, 0 is neutral, 1 is full CW.
	 */
	public void setSpeed(double speed) {
		for(int i = 0; i < (motorArray.size() - 1); i++) {
			motorArray.get(i).set(speed);
		}
	}
	
	/**
	 * Starts a timed rotation sequence.
	 * @param speed Speed from -1 to 1. -1 is full CCW, 0 is neutral, 1 is full CW.
	 * @param time Time (in milliseconds) for the sequence to run.
	 */
	public void autoSequence(double speed, long time) {
		long clock = System.currentTimeMillis(), 
				duration = (System.currentTimeMillis()) + Long.valueOf(time);
		
		log.send("Automatic motor sequence started for " + time + " milliseconds.");
		for(int i = 0; i < (motorArray.size() - 1); i++) {
			motorArray.get(i).set(speed);
		}
		while(clock < duration) {
			clock = System.currentTimeMillis();
		}
		for(int i = 0; i < (motorArray.size() - 1); i++) {
			motorArray.get(i).stopMotor();
		}
		log.send("Automatic motor sequence time expired.");
	}
	
	/**
	 * Poll the object for the number of currently slaved devices.
	 * @return Returns the number of connected slaves.
	 */
	public int getSlavesAmount() {
		return motorArray.size() - 1;
	}
	
	/**
	 * Checks to see if the specified port is slaved to this object.
	 * @param port PWM port to be checked.
	 * @return Whether or not the port is a slave.
	 */
	public boolean isSlave(int port) {
		int i = ports.indexOf(port);
		if(i == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Removes a slaved port from the object.
	 * @param port PWM port to be removed.
	 * @return Returns false if the slave is not part of the object.
	 */
	public boolean removeSlave(int port) {
		int i = ports.indexOf(port);
		if(i == -1) {
			return false;
		} else {
			motorArray.remove(i);
			ports.remove(i);
			log.send("Removed motor on port " + port + " from " + ports.get(0) + "'s group.");
			return true;
		}
	}
	
	/**
	 * Stops all motor rotation.
	 */
	public void stop() {
		for(int i = 0; i < (motorArray.size() - 1); i++) {
			motorArray.get(i).stopMotor();
		}
	}
	
	/**
	 * Stops and disables all motors.
	 */
	public void disable() {
		for(int i = 0; i < (motorArray.size() - 1); i++) {
			motorArray.get(i).stopMotor();
			motorArray.get(i).disable();
		}
		log.send(ports.size() + " motor(s) disabled.");
	}
}
