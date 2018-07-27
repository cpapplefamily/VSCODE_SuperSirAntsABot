package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Scissor_Reference_CG extends CommandGroup {

    public Scissor_Reference_CG() {
    	addSequential(new Scissor_Referenc_to_LimitSwitch());
    	//addSequential(new ScissorReference_Off_LimitSwitch());
    }
}
