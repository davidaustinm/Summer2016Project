package org.usfirst.frc.team4003.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**Made by Carl Slezak
 */
public class DriveAndSpin extends CommandGroup {
	double distance;
	double degrees;
	String direction;
	/**
	 * 
	 * @param Distance  How far to drive.
	 * @param Degrees	How many degrees to turn.
	 * @param Direction What direction to turn.
	 */
    public DriveAndSpin(double Distance, double Degrees,String Direction) {
        // Use requires() here to declare subsystem dependencies
        distance = Distance;
    	degrees = Degrees;
    	direction = Direction;
    	addSequential(new DriveForwardForDistance(distance));
    	addSequential(new SpinInPlace(degrees,direction));
    	
    }
}