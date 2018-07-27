package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_For_Distance;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Seek_Target;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Close;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Cube_n_Float;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Cube_n_Open;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Open;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class Auto_21_4_2_Right_Get_Cube_0 extends CommandGroup {

	//Secdond Cube Moves
	private static double ROBOT_DRIVE_TO_SECOND_CUBE_MOVE_1 = 5.5;
	private static double ROBOT_SEEK_TO_SECOND_CUBE_MOVE_1 = 5;
	private static double ROBOT_SEEK_BACK_AWAY_CUBE_MOVE = 2;
		
    public Auto_21_4_2_Right_Get_Cube_0() {
    	addParallel(new Intake_Open());																	//Open Intakes
    	addSequential(new Drive_For_Distance(-0.6, 0.0, 0.0, ROBOT_DRIVE_TO_SECOND_CUBE_MOVE_1, 0));	//Strife to Cube Stack
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	//addSequential(new Auto_Util_TimeDelay(.2));
    	addParallel(new Intake_Cube_n_Open());
    	addSequential(new Drive_Seek_Target(0.0,0.25,ROBOT_SEEK_TO_SECOND_CUBE_MOVE_1),3.5);
    	
    	addSequential(new Intake_Cube_n_Float(),.7);
    	
    	addSequential(new Intake_Close(1));
    	addSequential(new Drive_For_Distance(0.0, -0.3, 0.0, ROBOT_SEEK_BACK_AWAY_CUBE_MOVE));
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_21_5_0_Conditional_Cube_2_WhatSwitch());
    }
}
