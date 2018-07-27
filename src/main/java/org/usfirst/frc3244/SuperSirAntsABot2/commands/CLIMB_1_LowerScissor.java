package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CLIMB_1_LowerScissor extends CommandGroup {

    public CLIMB_1_LowerScissor() {
    	addParallel(new Intake_Close(1),1);
        addParallel(new Wrist_Up(1), 1);	
        addParallel(new Winch_Hooks_Retract());
        addSequential(new Scissor_To_Setpoint(Robot.scissor.DOWN,true));
        addSequential(new winch_SetClimbStarted(true));
    }
}
