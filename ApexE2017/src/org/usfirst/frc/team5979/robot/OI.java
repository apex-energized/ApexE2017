package org.usfirst.frc.team5979.robot;

import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team5979.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * @author Cameron Cunningham
 * @author Liam Williams
 *@version 1.0
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	// declaration for stick axes
	double lXAxis,lYAxis,rYAxis,rXAxis, lTAxis, rTAxis;
	// declaration for buttons
	boolean aButton;
	Joystick stick;
	public OI(){
		stick = new Joystick(0);
		refresh();
	}
	
	private void refresh() {
		lXAxis = stick.getRawAxis(0);
		lYAxis = stick.getRawAxis(1);
		lTAxis = stick.getRawAxis(2);
		rTAxis = stick.getRawAxis(3);
		rXAxis = stick.getRawAxis(4);
		rYAxis = stick.getRawAxis(5);
		aButton = stick.getRawButton(1);
	}
	
	public double getlXAxis() {
		refresh();
		return lXAxis;
	}
	
	public double getlYAxis() {
		refresh();
		return lYAxis;
	}
	
	public double getlTAxis() {
		refresh();
		return lTAxis;
	}
	
	public double getrTAxis() {
		refresh();
		return rTAxis;
	}
	
	public double getrXAxis() {
		refresh();
		return rXAxis;
	}
	
	public double getrYAxis() {
		refresh();
		return rYAxis;
	}
	
	public boolean getaButton() {
		refresh();
		return aButton;
	}
}

