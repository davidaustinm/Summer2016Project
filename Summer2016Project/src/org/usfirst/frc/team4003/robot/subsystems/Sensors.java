package org.usfirst.frc.team4003.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Sensors extends Subsystem {
	Encoder leftDriveEncoder, rightDriveEncoder;
	public Sensors() {
		leftDriveEncoder = new Encoder(0, 1);
		rightDriveEncoder = new Encoder(2,3);
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
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

