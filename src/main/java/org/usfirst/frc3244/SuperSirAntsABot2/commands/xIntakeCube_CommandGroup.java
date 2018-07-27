package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class xIntakeCube_CommandGroup extends CommandGroup {

    public xIntakeCube_CommandGroup() {
        //addParallel(new Intake_Float(1));
        addSequential(new Intake_Cube_n_Float());
        //addParallel(new IntakeCube_VariableSpeed());
    }
}
