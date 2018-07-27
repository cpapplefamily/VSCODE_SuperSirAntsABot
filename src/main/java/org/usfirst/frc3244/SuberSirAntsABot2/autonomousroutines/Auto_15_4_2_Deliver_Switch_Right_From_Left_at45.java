package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.Constants;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_For_Distance;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Turn_To_Setpoint;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Intake_Launch;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Scissor_To_Setpoint;
import org.usfirst.frc3244.SuperSirAntsABot2.commands.Wrist_Down;
import org.usfirst.frc3244.SuperSirAntsABot2.subsystems.Scissor;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_15_4_2_Deliver_Switch_Right_From_Left_at45 extends CommandGroup {

	private static final double ROBOT_DISTANCE_PASS_SWITCH 		= 29.0;
	private static final double ROBOT_PASS_SWITCH_TURN_ANGLE 	= 90.0;
	private static final double ROBOT_DISTANCE_CROSS_FIELD 		= 30.0;
	private static final double ROBOT_TURN_TO_SWITCH 			= -135.0;
	private static final double ROBOT_DISTANCE_TO_OVER_SCALE 	= 2.0;
	
    public Auto_15_4_2_Deliver_Switch_Right_From_Left_at45() {
    	addSequential(	new Drive_For_Distance(0.0, 0.7, 0.0, ROBOT_DISTANCE_PASS_SWITCH, 0.0)); 			//1 Drive Past Switch
    	addSequential(	new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_PASS_SWITCH_TURN_ANGLE));//, 3);			//2 Turn Behind Switch
    	addSequential(	new Drive_For_Distance(0.0, 0.7, 0.0, ROBOT_DISTANCE_CROSS_FIELD
    													, ROBOT_PASS_SWITCH_TURN_ANGLE)); 			//3 Drive Past Switch *We could try to add some rotation
    	//Be sure Both Commands are complete
    	addSequential(new CommandGroup() {
    		{
    			addParallel(	new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TURN_TO_SWITCH));//, 3);					//4 Turn To Scale
    	    	addSequential(	new Scissor_To_Setpoint(Scissor.SWITCH,true),3);//5 Scissor to Scale Height
    		}
    	});
    	
    	addSequential(new CommandGroup() {
    		{
    			addParallel(	new Wrist_Down(1));																	//6 Prep Wrist
    			addSequential(	new Drive_For_Distance(0.0, 0.3, 0.0, ROBOT_DISTANCE_TO_OVER_SCALE));				//7 Drive to Scale
    		}
    	});
    	
    	addSequential(	new Auto_Util_TimeDelay(.5));														//8 Settle Time
    	addSequential(	new Intake_Launch(-600),2);														//9 Launch Cube
    	
    	addSequential(new CommandGroup() {
    		{
    			addParallel(	new Drive_For_Distance(0.0, -0.3, 0.0, 2));											//10 Back Away from plate
    			addSequential(	new Scissor_To_Setpoint(Scissor.DOWN,true));//, 3);									//11 Scissor Down
    		}
		});
    }
}
