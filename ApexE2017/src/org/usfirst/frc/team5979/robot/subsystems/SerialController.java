package org.usfirst.frc.team5979.robot.subsystems;

import java.util.Calendar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

/**
 * This subsystem is designed for facilitating serial communications through a selected port.
 * Capable of switching between the MXP and RS-232 serial ports on the RoboRIO. 
 * The MXP serial port is default and will be automatically selected upon object creation.
 * 
 * @version 1.1.1
 * @author Liam Williams
 */

public class SerialController {
	public SerialController() {
		serialMXP = new SerialPort(9600, SerialPort.Port.kMXP);
        serialRS = new SerialPort(9600, SerialPort.Port.kOnboard);
        serial = serialMXP; //Sets the default serial to the MXP port.
	}
	/**
	 * @param port The port to be selected upon creation. "RS-232" or "MXP" accepted.
	 */
	public SerialController(String port) {
		serialMXP = new SerialPort(9600, SerialPort.Port.kMXP);
        serialRS = new SerialPort(9600, SerialPort.Port.kOnboard);
        if (port == "RS-232") {
        	serial = serialRS;
        } else if (port == "MXP") {
        	serial = serialMXP;
        } else {
        	serial = serialMXP;
        }
	}
	
	private SerialPort serialMXP, serialRS, serial;
	private Calendar stamp = Calendar.getInstance();
	
	/**
	 * Sends data out the MXP port with a timestamp.
	 * @param toOut Message to be sent out the MXP UART.tx serial port.
	 */
	public void send(String toOut) {
		stamp = Calendar.getInstance();
		serial.writeString("<" + stamp.getTime() + ">" + toOut);
	}
	
	/**
	 * Sends data out the MXP port without a timestamp leading.
	 * @param toOut Message to be sent out the MXP UART.tx serial port.
	 */
	public void sendRaw(String toOut) {
		serial.writeString(toOut);
	}
	
	/**
	 * Read any data being sent to the RoboRIO through the MXP port.
	 * Primarily for future compatibility.
	 * @return The data in the recieve bufer.
	 */
	public String recieve() {
		String toReturn = null;
		toReturn = serial.readString();
		return toReturn;
	}
	
	/**
	 * Switches the active serial port to the other port (MXP or RS-232).
	 * @return Returns a String saying which port has been selected.
	 */
	public String switchPort() {
		if(serial == serialRS) {
			serial = serialMXP;
			return "MXP";
		} else if (serial == serialMXP) {
			serial = serialRS;
			return "RS-232";
		}
		return null;
	}
	
	/**
	 * Polls the object to get the currently active port (MXP or RS-232).
	 * @return Returns a String saying which port has been selected.
	 */
	public String getPort() {
		if(serial == serialRS) {
			return "RS-232";
		} else if (serial == serialMXP) {
			return "MXP";
		}
		return null;
	}
	
	/**
	 * Sets active serial port to RS-232.
	 */
	public void setRS() {
		serial = serialRS;
	}
	
	/**
	 * Sets active serial port to MXP.
	 */
	public void setMXP() {
		serial = serialMXP;
	}
	
	/**
	 * Forces the serial buffer to be sent out and resets both ports.
	 */
	public void clear() {
		serialMXP.flush();
		serialRS.flush();
		serialMXP.reset();
		serialRS.reset();
	}

    public void initDefaultCommand() {
    }
}
