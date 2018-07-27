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
 *
 */
public class Auto_12_5_1_Left_Cube_2_to_Scale extends CommandGroup {

	//Secdond Cube Moves
	private static double ROBOT_DRIVE_TO_SECOND_SCAL_MOVE_1 = 4;
	private static double ROBOT_RETURN_TO_SCALE_1 = 0;
	private static double ROBOT_DRIVE_TO_SECOND_SCAL_MOVE_2 = 4;
	private static double ROBOT_TURN_TO_SCALE_2 = 25.0;
			
    public Auto_12_5_1_Left_Cube_2_to_Scale() {
    	//addParallel(new Scissor_To_Setpoint(Scissor.SCALE,true),4); THis could speed things up
    	addParallel(new Scissor_To_Setpoint(Scissor.SCALE,true),3);
    	addSequential(new Drive_For_Distance(0.3, -0.3, 0.0,ROBOT_DRIVE_TO_SECOND_SCAL_MOVE_1),2);
    	
    	
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_RETURN_TO_SCALE_1),3);
    	
    	// Make sure all movements are done
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Drive_For_Distance(0.0, 0.4, 0.0,ROBOT_DRIVE_TO_SECOND_SCAL_MOVE_2),2);
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TURN_TO_SCALE_2),3);	
//    	
    	// Make sure all movements are done
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Intake_Launch(-600),.5);														//8 Launch Cube
    	addParallel(new Drive_For_Distance(0.0, -0.3, 0.0, 2));											//9 Back Away from plate
    	addSequential(new Scissor_To_Setpoint(Scissor.DOWN,true),1);									//10 Lower Scissor
    }
}
