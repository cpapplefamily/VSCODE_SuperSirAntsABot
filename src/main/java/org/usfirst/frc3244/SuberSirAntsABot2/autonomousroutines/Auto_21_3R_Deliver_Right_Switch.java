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
public class Auto_21_3R_Deliver_Right_Switch extends CommandGroup {
	
	private static double ROBOT_DRIVE_TO_SWITCH_MOVE_1 = 8.25;
	private static double ROBOT_DRIVE_TO_SWITCH_MOVE_2 = 4.25;
	private static double ROBOT_DRIVE_BACK_AWAY_SWITCH_MOVE = 6.25;
	
    public Auto_21_3R_Deliver_Right_Switch() {
    	addParallel(new Wrist_Down(1));																//2 Prep Wrist
    	addParallel(new Scissor_To_Setpoint(Scissor.SWITCH,true),3);								//3 Scissor to Switch Height
    	addSequential(new Drive_For_Distance(0.5, 0.5, 0.0, ROBOT_DRIVE_TO_SWITCH_MOVE_1, 0));	
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Drive_Turn_To_Setpoint(0.0, 0.0, 0.0),.5);								//5 Turn back to Switch

    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	    	
    	//addSequential(new Auto_Util_TimeDelay(.1));													//6 Settle Time
    	addSequential(new Drive_For_Distance(0.0, 0.5, 0.0, ROBOT_DRIVE_TO_SWITCH_MOVE_2, 0.0),2);	//7 Move to Fence
    	addSequential(new Intake_Launch(-400),.5);													//8 Launch Cube
    	addParallel(new Drive_For_Distance(0.0, -0.5, 0.0, ROBOT_DRIVE_BACK_AWAY_SWITCH_MOVE));										//9 Back away from Switch
    	addSequential(new Scissor_To_Setpoint(Scissor.DOWN,true));									//10 Scissor Down
    	
    	// Start to get the next cube
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(new Auto_21_4_0_Conditional_Start_Cube2());
    }
}
