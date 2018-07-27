package org.usfirst.frc3244.SuperSirAntsABot2.commands;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Scissor_Safe_LowerToStow extends CommandGroup {

    public Scissor_Safe_LowerToStow() {
       addParallel(new Intake_Close(1),1);
       //addParallel(new Wrist_Up(1), 1);	
       addParallel(new Scissor_To_Setpoint(Robot.scissor.DOWN,true), 5);
    }
}
