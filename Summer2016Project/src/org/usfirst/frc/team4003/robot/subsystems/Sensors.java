package org.usfirst.frc.team4003.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Sensors extends Subsystem {
	Encoder leftDriveEncoder, rightDriveEncoder;
	double driveDifference;
	double leftEncoder;
	double rightEncoder;
	AHRS ahrs;
	double yawOffset = 0;
	
	public Sensors() {
		leftDriveEncoder = new Encoder(0, 1);
		rightDriveEncoder = new Encoder(2,3);
		try {
			ahrs = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex ) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
    	}	
	}
	
	public int getLeftDriveEncoder() {
		return -leftDriveEncoder.get();
	}
	
	public int getRightDriveEncoder() {
		return rightDriveEncoder.get();
	}
	
	public double getLeftDriveDistance() {
		return getLeftDriveEncoder()/22.5;
	}
	public double getRightDriveDistance() {
		return getRightDriveEncoder()/22.5;
	}
	public double getDriveDifference(double l1, double r1, double l2, double r2){
		r2 -= r1;
		l2 -= l1;
		return(l2 -r2);
	}
	
	public void setYawOffset() {
		yawOffset = getYaw();
	}
	
	public double getYaw(){
		return (-ahrs.getYaw()) - yawOffset;
	}
	
	public double getRoll(){
		return ahrs.getRoll();
	}
	
	public double getPitch(){
		return ahrs.getPitch();
	}
	
	public void resetYaw(){
		ahrs.zeroYaw();
	}
	
	public double getAngle() {
		return -ahrs.getAngle();
	}
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

