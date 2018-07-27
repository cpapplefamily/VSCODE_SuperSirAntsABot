package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Set_Gyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_32_1_Start_Right_Deliver_IF_Rscale extends CommandGroup {

    public Auto_32_1_Start_Right_Deliver_IF_Rscale() {
    	addSequential(new Drive_Set_Gyro(0.0),1);
    	addSequential(new Auto_32_2_Conditional_IsScale_R());
    }
}
