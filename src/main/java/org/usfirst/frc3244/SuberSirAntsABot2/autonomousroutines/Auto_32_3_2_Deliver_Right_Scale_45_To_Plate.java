package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_For_Distance;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Turn_To_Setpoint;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Launch;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Scissor_To_Setpoint;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Wrist_Down;
import org.usfirst.frc3244.SuperSirAntsABot2.subsystems.Scissor;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 */
public class Auto_32_3_2_Deliver_Right_Scale_45_To_Plate extends CommandGroup {

	private static final double ROBOT_DISTANCE_TO_SCALE 	= 34.0;
	//private static final double ROBOT_DISTANCE_TO_SCALE2 	= 2.0;
	private static final double ROBOT_TO_SCALE_ANGLE 		= -25.0;
	
    public Auto_32_3_2_Deliver_Right_Scale_45_To_Plate() {
    	addParallel(new Wrist_Down(1));														//1 Prep Wrist
    	addParallel(new Scissor_To_Setpoint(Scissor.SCALE,true),5);;						//2 Scissor to Scale Height
    	addSequential(new Drive_For_Distance(0.0, 0.7, 0.0, ROBOT_DISTANCE_TO_SCALE, 0.0));	//3 Drive to Scale
    	
    	addSequential(new Auto_Util_TimeDelay(.1));
    	
    	addSequential(new WaitForChildren());
    	
    	//addSequential(new Drive_For_Distance(0.0, 0.5, 0.0, ROBOT_DISTANCE_TO_SCALE2, 0.0));	//3 Drive to Scale
    	
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TO_SCALE_ANGLE), 2);		//5 Rotate to Scale
    	
    	addSequential(new Auto_Util_TimeDelay(.1));														//6 Settle Time
    	//Drive to Not Required addSequential(new Drive_For_Distance(0.0, 0.3, 0.0, 1, ROBOT_TO_SCALE_ANGLE),2);	//7 Drive to Scale
    	
    	// Make sure all movements are done
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Intake_Launch(-400),.5);														//8 Launch Cube
    	
    	addParallel(new Drive_For_Distance(0.0, -0.3, 0.0, 2));											//9 Back Away from plate
    	addSequential(new Scissor_To_Setpoint(Scissor.DOWN,true),2);									//10 Lower Scissor
    	
    	// Start to get the next cube
    	
    	//Make sure all Steps are complete
    	//addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_32_4_0_Conditional_Start_Cube2());
    }
}
