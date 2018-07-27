package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Winch_To_Setpoint extends Command {

	private double m_distance;
	private boolean m_continueToServo;
	
    public Winch_To_Setpoint(double distance, boolean continueTOServo) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    	m_distance = distance;
    	m_continueToServo = continueTOServo;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.set_PreserveHeading(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.winch.my_WinchMotionMagic(-m_distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.winch.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.drive.set_PreserveHeading(true);
    	if(!m_continueToServo) {
    		Robot.winch.my_WinchStop();
    
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
