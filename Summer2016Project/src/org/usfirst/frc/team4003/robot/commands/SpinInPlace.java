package org.usfirst.frc.team4003.robot.commands;

import org.usfirst.frc.team4003.robot.Robot;
import org.usfirst.frc.team4003.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**Made by Carl Slezak
 *
 */
public class SpinInPlace extends Command {
	double degrees;
	double turnLeft,turnRight;
	double width = RobotMap.ROBOTWIDTH;
	double fraction;
	double driveIncrementL,driveIncrementR;
	String direction;
	/**
	 * @param Degrees How many degrees in any direction to turn.
	 * @param Direction What direction to turn.
	 */
    public SpinInPlace(double Degrees,String Direction) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        degrees = Degrees;
        direction = Direction;}

    // Called just before this Command runs the first time
    protected void initialize() {
    	fraction = degrees/360;
    	driveIncrementL = Robot.sensors.getLeftDriveDistance();
    	driveIncrementR = Robot.sensors.getRightDriveDistance();
    	
    	switch (direction){
    		case "Left": turnLeft = -(((2*(Math.PI)*(width/2)))*fraction);
    		turnRight = (((2*(Math.PI)*(width/2)))*fraction);
    		break;
    		
    		case "Right": turnRight = (((2*(Math.PI)*(width/2)))*fraction);
    		turnRight = -(((2*(Math.PI)*(width/2)))*fraction);
    		break;
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch (direction){
    		case "Left": Robot.driveTrain.setPower(-0.5, 0.5);
    			if(Robot.sensors.getLeftDriveDistance()-driveIncrementL <= turnLeft){
    				Robot.driveTrain.setPower(0, 0.5);;
    			}
    			else if(Robot.sensors.getRightDriveDistance() >= turnRight){
    				Robot.driveTrain.setPower(-0.5, 0);
    			}
    		break;
    		
    		case "Right": Robot.driveTrain.setPower(0.5, -0.5);
    			if(Robot.sensors.getLeftDriveDistance()-driveIncrementL >= turnLeft){
    				Robot.driveTrain.setPower(0, -0.5);
    				
    			}
    			else if(Robot.sensors.getRightDriveDistance() <= turnRight){
    				Robot.driveTrain.setPower(0.5, 0);
    			}
    		break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean r;
    	switch (direction){
    		case "Left": r = Robot.sensors.getLeftDriveDistance()-driveIncrementL <= turnLeft &&
    				Robot.sensors.getRightDriveDistance() >= turnRight;
    		
    		case "Right": r = Robot.sensors.getLeftDriveDistance()-driveIncrementL >= turnLeft &&
    				Robot.sensors.getRightDriveDistance() <= turnRight;
    		
    		default: r=false;
    	}
		
    	return r;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setPower(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
