package org.usfirst.frc.team4003.robot.commands;

import org.usfirst.frc.team4003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrainCommand extends Command {

    public DriveTrainCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    public double deadBand(double x) {
    	if (Math.abs(x) < 0.1) return 0;
    	return x;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftPower = -Robot.oi.driver.getLeftJoyY();
    	double rightPower = -Robot.oi.driver.getRightJoyY();
    	Robot.driveTrain.setPower(deadBand(leftPower), deadBand(rightPower));
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
