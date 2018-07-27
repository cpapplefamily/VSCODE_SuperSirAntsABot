package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Set_Gyro;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_15_1_Start_Left_Deliver_IF_Lswitch_Rswitch extends CommandGroup {

    public Auto_15_1_Start_Left_Deliver_IF_Lswitch_Rswitch() {
    	addSequential(new Drive_Set_Gyro(0.0),1);
    	addSequential(new Auto_15_2_Conditional_IsSwitch_L_R());
    }
}
