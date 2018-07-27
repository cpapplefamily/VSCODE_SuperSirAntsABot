package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_For_Distance;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Seek_Target;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Turn_To_Setpoint;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Close;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Cube_n_Float;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Cube_n_Open;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Launch;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Open;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Scissor_To_Setpoint;
import org.usfirst.frc3244.SuperSirAntsABot2.subsystems.Scissor;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *Reviewed
 */
public class Auto_32_4_1_Left_Get_Cube_6 extends CommandGroup {

	//Secdond Cube Moves
	private static double ROBOT_TURN_TO_CUBE = -150;
	private static double ROBOT_DRIVE_TO_SECOND_CUBE_MOVE_1 = 5.0;
	private static double ROBOT_SEEK_TO_SECOND_CUBE_MOVE_1 = 4;
	private static double ROBOT_SEEK_BACK_AWAY_CUBE_MOVE = 1;
		
    public Auto_32_4_1_Left_Get_Cube_6() {
    	addParallel(new Scissor_To_Setpoint(Scissor.DOWN,true),3);
    	addParallel(new Intake_Open());																	//Open Intakes
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TURN_TO_CUBE),2);	
    	
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Drive_For_Distance(0.1, 0.4, 0.0, ROBOT_DRIVE_TO_SECOND_CUBE_MOVE_1, ROBOT_TURN_TO_CUBE));	//Get closer to Cube
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_Util_TimeDelay(.2));
    	addParallel(new Intake_Cube_n_Open());
    	addSequential(new Drive_Seek_Target(0.0,0.25,ROBOT_SEEK_TO_SECOND_CUBE_MOVE_1),4);  //Seek Cube for 4 sec max
    	
    	addSequential(new Intake_Cube_n_Float(),.7);
    	
    	addSequential(new Intake_Close(.1));
    	addParallel(new Intake_Launch(200));													//Holed cube
    	addSequential(new Drive_For_Distance(0.0, -0.3, 0.0, ROBOT_SEEK_BACK_AWAY_CUBE_MOVE));	//Back from stack
    	
    	addSequential(new Intake_Close(.1));													//Uses Requires intakes to stop motors
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_32_5_0_Conditional_WhatPlate());
    }
}
