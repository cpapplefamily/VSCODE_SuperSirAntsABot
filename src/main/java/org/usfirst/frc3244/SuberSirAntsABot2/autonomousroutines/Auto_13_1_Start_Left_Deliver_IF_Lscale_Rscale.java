package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Set_Gyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_13_1_Start_Left_Deliver_IF_Lscale_Rscale extends CommandGroup {

    public Auto_13_1_Start_Left_Deliver_IF_Lscale_Rscale() {
    	addSequential(new Drive_Set_Gyro(0.0),1);
    	addSequential(new Auto_13_2_Conditional_IsScale_L_R());
    }
}
