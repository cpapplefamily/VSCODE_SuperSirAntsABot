package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CLIMB_31_Extend_Scissor_With_Hooks extends Command {

    public CLIMB_31_Extend_Scissor_With_Hooks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.scissor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.scissor.my_set_MotoinMagic_Start_Memory();
    	Robot.scissor.my_set_ControlProfile(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.scissor.my_ScissorMotionMagic(Robot.scissor.CLIMB_START);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.scissor.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
