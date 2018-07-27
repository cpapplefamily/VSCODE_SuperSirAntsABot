package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Intake_Set_LaunchSpeed_HI extends InstantCommand {
	
    public Intake_Set_LaunchSpeed_HI() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
       
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.intake.my_Set_LaunchSpeed(Robot.intake.LAUNCH_SPEED_HI);
    	Robot.oi.launchPad.setOutput(7,true);
    	Robot.oi.launchPad.setOutput(8,false);
    	Robot.oi.launchPad.setOutput(9,false);
    }

}
