package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Set_Gyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_33_1_Start_Right_Deliver_IF_Rscale_Lscale extends CommandGroup {

    public Auto_33_1_Start_Right_Deliver_IF_Rscale_Lscale() {
    	addSequential(new Drive_Set_Gyro(0.0),1);
    	addSequential(new Auto_33_2_Conditional_IsScale_R_L());
    }
}
