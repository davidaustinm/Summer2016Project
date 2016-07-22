package org.usfirst.frc.team4003.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Shooter extends Subsystem {
    CANTalon shooter0, shooter1;
    public Shooter() {
    	shooter0 = new CANTalon(15);
    	shooter1 = new CANTalon(23);
    	shooter0.setInverted(true);
    	shooter1.setInverted(true);
    }
    
    public void setPower(double power) {
    	shooter0.set(power);
    	shooter1.set(power);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

