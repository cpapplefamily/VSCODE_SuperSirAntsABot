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
public class Auto_12_5_3_Left_Cube_2_to_Switch extends CommandGroup {

	//Secdond Cube Moves
	private static double ROBOT_DRIVE_TO_SECOND_SWITCH_MOVE_1 = 1;
	
			
    public Auto_12_5_3_Left_Cube_2_to_Switch() {
    	
    	addSequential(new Scissor_To_Setpoint(Scissor.SWITCH,true),4);
    	
    	addSequential(new Drive_For_Distance(0.0, 0.4, 0.0,ROBOT_DRIVE_TO_SECOND_SWITCH_MOVE_1),2);
     	
    	// Make sure all movements are done
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Intake_Launch(-600),.5);														//8 Launch Cube
    	addParallel(new Drive_For_Distance(0.0, -0.3, 0.0, 2));											//9 Back Away from plate
    	addSequential(new Scissor_To_Setpoint(Scissor.DOWN,true),1);									//10 Lower Scissor
    }
}
