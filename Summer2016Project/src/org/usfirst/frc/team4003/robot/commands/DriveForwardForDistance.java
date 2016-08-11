package org.usfirst.frc.team4003.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4003.robot.*;
/**
 *
 */
public class DriveForwardForDistance extends Command {
	double distance;
	double stopDistance;
	double targetYaw = 0;
	double Kp = 0.02;
    public DriveForwardForDistance(double d) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        distance = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopDistance = Robot.sensors.getRightDriveDistance() + distance;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentYaw = Robot.sensors.getYaw();
    	double error = targetYaw - currentYaw;
    	double correction = Kp * error;
    	double leftPower = 0.5 - correction;
    	double rightPower = 0.5 + correction;
    	
    	
    	Robot.driveTrain.setPower(leftPower, rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.sensors.getRightDriveDistance() > stopDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setPower(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
