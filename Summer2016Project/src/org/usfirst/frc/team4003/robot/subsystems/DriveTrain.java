package org.usfirst.frc.team4003.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team4003.robot.RobotMap;
import org.usfirst.frc.team4003.robot.commands.*;

/**
 *
 */
public class DriveTrain extends Subsystem {
    CANTalon leftFront, leftBack, rightFront, rightBack;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DriveTrain() {
    	leftFront = new CANTalon(RobotMap.LEFTFRONTDRIVE);
    	leftBack = new CANTalon(RobotMap.LEFTBACKDRIVE);
    	rightFront = new CANTalon(RobotMap.RIGHFRONTDRIVE);
    	rightBack = new CANTalon(RobotMap.RIGHTBACKDRIVE);
    	rightBack.setInverted(true);
    	rightFront.setInverted(true);
    }
    
    public void setPower(double left, double right) {
    	leftFront.set(left);
    	leftBack.set(left);
    	rightFront.set(right);
    	rightBack.set(right);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTrainCommand());
    }
}

