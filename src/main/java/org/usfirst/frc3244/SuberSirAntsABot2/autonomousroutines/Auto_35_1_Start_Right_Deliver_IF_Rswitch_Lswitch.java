package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Set_Gyro;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_35_1_Start_Right_Deliver_IF_Rswitch_Lswitch extends CommandGroup {

    public Auto_35_1_Start_Right_Deliver_IF_Rswitch_Lswitch() {
    	addSequential(new Drive_Set_Gyro(0.0),1);
    	addSequential(new Auto_35_2_Conditional_IsSwitch_R_L());
    }
}
