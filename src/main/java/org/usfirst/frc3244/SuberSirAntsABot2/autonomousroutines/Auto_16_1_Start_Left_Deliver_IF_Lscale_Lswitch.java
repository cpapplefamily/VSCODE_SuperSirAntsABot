package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;


import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Set_Gyro;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_16_1_Start_Left_Deliver_IF_Lscale_Lswitch extends CommandGroup {

    public Auto_16_1_Start_Left_Deliver_IF_Lscale_Lswitch() {
    	addSequential(new Drive_Set_Gyro(0.0),1);
    	addSequential(new Auto_16_2_Conditional_IsScale_L());  
    }
}
