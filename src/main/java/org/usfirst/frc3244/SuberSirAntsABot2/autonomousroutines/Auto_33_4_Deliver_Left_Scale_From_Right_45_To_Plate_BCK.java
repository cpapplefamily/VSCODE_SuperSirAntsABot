package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.Constants;
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
public class Auto_33_4_Deliver_Left_Scale_From_Right_45_To_Plate_BCK extends CommandGroup {

	private static final double ROBOT_DISTANCE_PASS_SWITCH 		= 29.0;
	private static final double ROBOT_PASS_SWITCH_TURN_ANGLE 	= -90.0;  	//Angles are Field Orientated
	private static final double ROBOT_DISTANCE_CROSS_FIELD 		= 30.0;
	private static final double ROBOT_TURN_TO_SCALE 			= 45.0;		//Angles are Field Orientated
	private static final double ROBOT_DISTANCE_TO_OVER_SCALE 	= 6.0;
	
    public Auto_33_4_Deliver_Left_Scale_From_Right_45_To_Plate_BCK() {
    	addSequential(	new Drive_For_Distance(0.0, 0.7, 0.0, ROBOT_DISTANCE_PASS_SWITCH, 0.0)); 			//1 Drive Past Switch
    	addSequential(	new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_PASS_SWITCH_TURN_ANGLE),2);//, 3);			//2 Turn Behind Switch
    	addSequential(	new Drive_For_Distance(0.0, 0.7, 0.0, ROBOT_DISTANCE_CROSS_FIELD, ROBOT_PASS_SWITCH_TURN_ANGLE)); 			//3 Drive Past Switch *We could try to add some rotation
    	
    	addParallel(	new Wrist_Down(1),3);	
    	addSequential(	new Drive_Turn_To_Setpoint(0.0, 0.0, ROBOT_TURN_TO_SCALE), 3);					//4 Turn To Scale
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	addSequential(	new Scissor_To_Setpoint(Scissor.SCALE,true),5);//, 3);,Constants.kScissorToSetpointTimout_S);//5 Scissor to Scale Height
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	//addParallel(	new Wrist_Down(1));																	//6 Prep Wrist
    	addSequential(	new Drive_For_Distance(0.0, 0.3, 0.0, ROBOT_DISTANCE_TO_OVER_SCALE));				//7 Drive to Scale
    	
    	//Make sure all Steps are complete
    	addSequential(new WaitForChildren());
    	
    	//addSequential(	new Auto_Util_TimeDelay(.5));														//8 Settle Time
    	addSequential(	new Intake_Launch(-800),1);														//9 Launch Cube
    	
    	addParallel(	new Drive_For_Distance(0.0, -0.3, 0.0, 2));											//10 Back Away from plate
    	addSequential(	new Scissor_To_Setpoint(Scissor.DOWN,true));//, 3);									//11 Scissor Down
    	
    }
}
