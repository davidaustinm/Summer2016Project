package org.usfirst.frc.team4003.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4003.robot.commands.*;

/**
 *
 */
public class Conveyor extends Subsystem {
    Talon conveyor;
    Talon conveyor2;
    public Conveyor() {
    	conveyor = new Talon(1);
    	conveyor2 = new Talon(0);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void setPower(double power) {
    	conveyor.set(power);
    	conveyor2.set(power);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ConveyorCommand());
    }
}

