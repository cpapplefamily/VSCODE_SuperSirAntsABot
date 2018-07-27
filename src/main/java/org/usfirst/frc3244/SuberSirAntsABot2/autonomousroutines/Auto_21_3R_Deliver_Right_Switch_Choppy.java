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
public class Auto_21_3R_Deliver_Right_Switch_Choppy extends CommandGroup {
	
	private static double ROBOT_TURN_TO_PLATE = 45.0;
	private static double ROBOT_DRIVE_TO_SWITCH_MOVE_1 = 10.0;
	private static double ROBOT_DRIVE_TO_SWITCH_MOVE_2 = 3.0;
	
    public Auto_21_3R_Deliver_Right_Switch_Choppy() {
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TURN_TO_PLATE),3);				//1 Turn to RIGHT PLate
    	addParallel(new Wrist_Down(1));																//2 Prep Wrist
    	addParallel(new Scissor_To_Setpoint(Scissor.SWITCH,true),3);								//3 Scissor to Switch Height
    	addSequential(new Drive_For_Distance(0.0, 0.3, 0.0, ROBOT_DRIVE_TO_SWITCH_MOVE_1,
    																ROBOT_TURN_TO_PLATE));			//4 Move 1 to Switch
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, 0.0),3);								//5 Turn back to Switch

    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_Util_TimeDelay(.5));													//6 Settle Time
    	addSequential(new Drive_For_Distance(0.0, 0.3, 0.0, ROBOT_DRIVE_TO_SWITCH_MOVE_2, 0.0));	//7 Move to Fence
    	addSequential(new Intake_Launch(-600),2);													//8 Launch Cube
    	addParallel(new Drive_For_Distance(0.0, -0.3, 0.0, 5));										//9 Back away from Switch
    	addSequential(new Scissor_To_Setpoint(Scissor.DOWN,true));									//10 Scissor Down
    }
}
