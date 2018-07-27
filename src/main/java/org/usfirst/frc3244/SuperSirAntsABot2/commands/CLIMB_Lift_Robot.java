package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.subsystems.Winch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CLIMB_Lift_Robot extends CommandGroup {

    public CLIMB_Lift_Robot() {
    	addSequential(new Winch_Zero_Encoder());
    	addSequential(new Winch_To_Setpoint(Winch.Winch_TAKE_UP, false));
    	addParallel(new Winch_To_Setpoint(Winch.WINCH_DISTANCE, true));
    	addSequential(new Scissor_Climb());
    }
}
