package org.usfirst.frc.team4003.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4003.robot.*;
/**
 *
 */
public class ConveyorCommand extends Command {

    public ConveyorCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    protected double deadBand(double x) {
    	if (Math.abs(x) < 0.1) return 0;
    	return x;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.conveyor.setPower(deadBand(Robot.oi.operator.getRightJoyY()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
