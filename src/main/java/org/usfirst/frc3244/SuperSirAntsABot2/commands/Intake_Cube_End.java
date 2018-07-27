package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Intake_Cube_End extends TimedCommand {

    public Intake_Cube_End(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.intake);
    }

    public Intake_Cube_End() {
        super(.2);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.intake);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.intake.my_intake(0);
    	Robot.intake.my_intake(500);
    	//Cheat and clamp
    	Robot.intake.my_claw_close();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after timeout
    protected void end() {
    	//Robot.intake.my_intake(0);
    	//Maintain a little revere rotation
    	Robot.intake.my_intake(30);
    	//Cheat and clamp
    	Robot.intake.my_claw_close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
