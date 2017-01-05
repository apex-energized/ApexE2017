package org.usfirst.frc.team5979.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import java.util.Calendar;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

/**
 * This subsystem is designed for facilitating serial communications, specificaly for
 * sending diagnostc and logging information to the SF OpenLog via the RS-232 port.
 * 
 * @author Liam Williams
 */

public class SerialController extends Subsystem {
	private SerialPort serial;
	private Calendar stamp = Calendar.getInstance();
	
	/**
	 * Sends data out the RS-232 port with a timestamp.
	 * @param toOut Message to be sent out the RS-232 serial port.
	 * @author Liam Williams
	 */
	public void send(String toOut) {
		stamp = Calendar.getInstance();
		String finalOut = null;
		serial.writeString("<" + stamp.getTime() + ">" + finalOut);
	}
	
	/**
	 * Forces the serial buffer to be sent out and resets.
	 * @author Liam Williams
	 */
	public void clear () {
		serial.flush();
		serial.reset();
	}

    public void initDefaultCommand() {
        serial = new SerialPort(9600, SerialPort.Port.kOnboard);
    }
}
