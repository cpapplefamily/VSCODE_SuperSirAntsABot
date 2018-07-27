package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Wrist_Up_CommandGroup extends CommandGroup {

    public Wrist_Up_CommandGroup() {
       addSequential(new Intake_Close(.1), 1);
       addSequential(new Wrist_Up(1), 1);
    }
}
