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
public class Auto_31_3_Deliver_Right_Switch extends CommandGroup {

	private static final double ROBOT_DISTANCE_TO_SWITCH = 19.0;
	private static final double ROBOT_TO_SWITCH_ANGLE = -90.0;
	private static final double ROBOT_DISTANCE_TO_SWITCH_WALL = 1.0;
	
    public Auto_31_3_Deliver_Right_Switch() {
    	addParallel(new Wrist_Down(1));															//1 Prep Wrist
    	addParallel(new Scissor_To_Setpoint(Scissor.SWITCH,true),5);						//2 Raise Scissor
    	addSequential(new Drive_For_Distance(0.0, 0.5, 0.0, ROBOT_DISTANCE_TO_SWITCH, 0.0),5); 	//3 Drive to Switch
    	addSequential(new Auto_Util_TimeDelay(.5));												//4 Settle Time
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TO_SWITCH_ANGLE), 3);			//5 Turn to Switch

    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_Util_TimeDelay(.1));												//6 Settle Time
    	addSequential(new Drive_For_Distance(0.0, 0.3, 0.0, ROBOT_DISTANCE_TO_SWITCH_WALL, ROBOT_TO_SWITCH_ANGLE),2);			//7 Drive to Wall
    	addSequential(new Intake_Launch(-600),2);												//8 Launch Cube
    	addParallel(new Drive_For_Distance(0.0, -0.3, 0.0, 2));									//9 Back Away from plate
    	addSequential(new Scissor_To_Setpoint(Scissor.DOWN,true),3);						//10 Lower Scissor
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_31_90_Start_Cube2());
  
    }
}
