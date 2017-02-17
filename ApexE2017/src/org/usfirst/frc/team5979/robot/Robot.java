
package org.usfirst.frc.team5979.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5979.robot.commands.ExampleCommand;
import org.usfirst.frc.team5979.robot.subsystems.*;
import org.usfirst.frc.team5979.robot.subsystems.dashboard.DashboardDataSender;
import org.usfirst.frc.team5979.robot.subsystems.driveTrain.*;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is the primary robot class for controlling the robot and is automatically run
 * by the RoboRIO's VM
 * 
 * @author Liam Williams
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public SerialController log = new SerialController();

    Command autonomousCommand;
    SendableChooser chooser;
    CameraController cam;
    TankDrive dTrain;
    MotorController climber;
    Aggregator agg;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        cam = new CameraController();
        cam.init();
        dTrain = new TankDrive(0, 1, 3, 4);
        climber = new MotorController(6);
        agg = new Aggregator();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	log.send("Disengaging.");
    	log.clear();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        synchronized(this) {
        	dTrain.autoDrive(2, 0, 1000);
        }
        synchronized(this) {
        	dTrain.autoDrive(0.1, 1, 1000);
        }
       
        synchronized(this) {
        	dTrain.autoDrive(-.5, 0, 10000);
        }
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        dTrain.tank(oi.getlYAxis(), oi.getrYAxis());
        climber.setSpeed(agg.combineSpeed(oi.getlTAxis(), oi.getrTAxis()));
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
