package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class xIntake_Cube_Finnish_CommandGroup extends CommandGroup {

    public xIntake_Cube_Finnish_CommandGroup() {
       addSequential(new Intake_Cube_n_Float(),2);
       addSequential(new Scissor_To_Setpoint(Robot.scissor.DRIVE_WITH_CUBE,true));
    }
}
