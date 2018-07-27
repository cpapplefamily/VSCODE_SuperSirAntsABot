package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class CLIMB_31_Reset_Winch_Encoder extends TimedCommand {

    public CLIMB_31_Reset_Winch_Encoder() {
        super(1);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.winch.my_zeroEncoders();
    	Robot.winch.my_setClimbStarted(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
