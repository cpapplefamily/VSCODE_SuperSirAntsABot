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
public class Auto_32_3_1_Deliver_Right_Scale_90_To_Plate extends CommandGroup {

	private static final double ROBOT_TO_SCALE_ANGLE 		= -90.0;
	private static final double ROBOT_DISTANCE_TO_SCALE 	= 41.5;
	
    public Auto_32_3_1_Deliver_Right_Scale_90_To_Plate() {
    	addParallel(new Wrist_Down(1));														//1 Prep Wrist
    	addParallel(new Scissor_To_Setpoint(Scissor.SCALE,true),5);;						//2 Scissor to Scale Height
    	addSequential(new Drive_For_Distance(0.1, 0.7, 0.0, ROBOT_DISTANCE_TO_SCALE, 0.0));	//3 Drive to Scale
    	addSequential(new Auto_Util_TimeDelay(.5));											//4 Settle Time
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TO_SCALE_ANGLE), 3);		//5 Rotate to Scale

    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_Util_TimeDelay(.5));											//6 Settle Time
    	//Drive to Not Required addSequential(new Drive_For_Distance(0.0, 0.3, 0.0, 1, ROBOT_TO_SCALE_ANGLE),2);	//7 Drive to Scale
    	addSequential(new Intake_Launch(-600),2);											//8 Launch Cube
    	addParallel(new Drive_For_Distance(0.0, -0.3, 0.0, 2));								//9 Back Away from plate
    	addSequential(new Scissor_To_Setpoint(Scissor.DOWN,true),3);						//10 Lower Scissor
    }
}
