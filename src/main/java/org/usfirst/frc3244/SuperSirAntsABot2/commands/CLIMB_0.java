package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CLIMB_0 extends CommandGroup {

    public CLIMB_0() {
        addSequential(new CLIMB_1_LowerScissor());
        addSequential(new Scissor_Reference_CG());
        addSequential(new CLIMB_2_ClipHooks());
        addSequential(new CLIMB_30_Command_Group());
    }
}
