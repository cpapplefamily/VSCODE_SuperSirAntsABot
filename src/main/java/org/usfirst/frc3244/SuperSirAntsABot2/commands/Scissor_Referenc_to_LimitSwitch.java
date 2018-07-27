package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Scissor_Referenc_to_LimitSwitch extends Command {

    public Scissor_Referenc_to_LimitSwitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.scissor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.scissor.my_zeroEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.scissor.my_referenc_Encoders_to_LimitSwitch();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.scissor.m_Left_REV_LimitSwitch & Robot.scissor.m_Right_REV_LimitSwitch;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.scissor.my_ScissorStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
