package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class winch_SetClimbStarted extends Command {
	private boolean m_set_climbstartedValue;
    public winch_SetClimbStarted(boolean b) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    	m_set_climbstartedValue = b;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.winch.my_setClimbStarted(m_set_climbstartedValue);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.winch.my_get_ClimbStarted() == m_set_climbstartedValue;
    }

    // Called once after isFinished returns true
    protected void end() {
    	DriverStation.reportError("Climb Started set To: " + m_set_climbstartedValue, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
