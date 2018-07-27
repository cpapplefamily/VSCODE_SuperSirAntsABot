package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_For_Distance;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Turn_To_Setpoint;
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
public class Auto_11_93_1_Second_Cube_To_Switch extends CommandGroup {

	private static final double ROBOT_TO_CUBE1_ANGLE = 135.0;
	private static final double ROBOT_TO_SWITCH_MOVE = 2;
	
    public Auto_11_93_1_Second_Cube_To_Switch() {
    
    	addSequential(new Scissor_To_Setpoint(Scissor.SWITCH,true),2);
    	addSequential(new Drive_For_Distance(0.0, 0.3, 0, ROBOT_TO_SWITCH_MOVE, ROBOT_TO_CUBE1_ANGLE),3);
    	
    	addSequential(new Intake_Launch(-600),2);											//8 Launch Cube
    	
    	addParallel(new Drive_For_Distance(0.0, -0.3, 0.0, 3));								//9 Back Away from plate
    	addSequential(new Scissor_To_Setpoint(Scissor.DOWN,true));							//10 Lower Scissor
    }
}
