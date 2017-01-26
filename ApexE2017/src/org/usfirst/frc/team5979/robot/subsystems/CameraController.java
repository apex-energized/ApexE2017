package org.usfirst.frc.team5979.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;

/**
 * Initializes the default USB camera and enables it for basic streaming to
 * the dashboard.
 * @version 1.1
 * @author Liam Williams
 */
public class CameraController {
	CameraServer camera;
	public CameraController() {
		camera = CameraServer.getInstance();
	}
	/**
	 * Initializes the camera with default settings.
	 */
	public void init() {
		//camera.setQuality(50);
		camera.startAutomaticCapture();
	}
	/**
	 * Initializes the camera with custom quality.
	 * @param quality Camera quality to be selected.
	 * @deprecated
	 */
	public void init(int quality) {
		//camera.setQuality(quality);
		camera.startAutomaticCapture();
	}
}
