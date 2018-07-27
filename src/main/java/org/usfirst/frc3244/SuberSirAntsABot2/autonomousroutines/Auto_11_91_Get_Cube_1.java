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
public class Auto_11_91_Get_Cube_1 extends CommandGroup {
	private static final double ROBOT_TO_CUBE1_MOVE_1 = 12;
	private static final double ROBOT_TO_CUBE1_ANGLE = 135.0;
	private static final double ROBOT_SEEK_TO_SECOND_CUBE_MOVE_1 = 4;
	private static final double ROBOT_SEEK_BACK_AWAY_CUBE_MOVE = 1;
    public Auto_11_91_Get_Cube_1() {
    	
    	addParallel(new Intake_Open());
    	addSequential(new Drive_For_Distance(-0.6, 0.0, 0.0, ROBOT_TO_CUBE1_MOVE_1),90);	
    	
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TO_CUBE1_ANGLE));
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_Util_TimeDelay(.2));
    	addParallel(new Intake_Cube_n_Open());
    	addSequential(new Drive_Seek_Target(0.0,0.25,ROBOT_SEEK_TO_SECOND_CUBE_MOVE_1),3);
    	
    	addSequential(new Intake_Cube_n_Float(),.7);
    	
    	addSequential(new Intake_Close(.1));
    	addParallel(new Intake_Launch(200));
    	
    	addSequential(new Drive_For_Distance(0.0, -0.3, 0.0, ROBOT_SEEK_BACK_AWAY_CUBE_MOVE));
    	
    	addSequential(new Intake_Close(.1));
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_11_93_0_Conditional_SecondPlate());
    	
    }
}
