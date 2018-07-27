package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CLIMB_30_Command_Group extends CommandGroup {

    public CLIMB_30_Command_Group() {
    	addParallel(new CLIMB_31_Reset_Winch_Encoder());
    	//Going to manually extend
    	//addSequential(new CLIMB_31_Extend_Scissor_With_Hooks());
    }
}
