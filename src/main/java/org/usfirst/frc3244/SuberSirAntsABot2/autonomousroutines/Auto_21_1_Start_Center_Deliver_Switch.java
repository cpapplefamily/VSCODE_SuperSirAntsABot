package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Set_Gyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_21_1_Start_Center_Deliver_Switch extends CommandGroup {

    public Auto_21_1_Start_Center_Deliver_Switch() {
    	addSequential(new Drive_Set_Gyro(0.0),1);
    	addSequential(new Auto_21_2_Conditional_WhatSwitch());
    }
}
