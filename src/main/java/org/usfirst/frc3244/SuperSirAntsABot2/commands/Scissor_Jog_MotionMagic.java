package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Scissor_Jog_MotionMagic extends Command {
	private double m_Setpoint;
	private boolean m_continueToServo;
	
    public Scissor_Jog_MotionMagic(boolean continueTOServo) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.scissor);
    	m_continueToServo = continueTOServo;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.scissor.my_set_MotoinMagic_Start_Memory();
    	Robot.scissor.my_set_ControlProfile(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double joystick = Robot.oi.co_Driver_Right_AxisY();
    	double current = Robot.scissor.my_get_Current_Height();
    	if(joystick>0) {
    		m_Setpoint = Robot.scissor.CLIMB_START;
    	}else {
    		m_Setpoint = Robot.scissor.DOWN;
    	}
    	
    	Robot.scissor.my_ScissorMotionMagic(m_Setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //Jog or Stick Follower Mode so Never complete untill new command or sticks are released
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(!m_continueToServo || Robot.scissor.getOvertraveles()) {
    		Robot.scissor.my_ScissorStop();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
