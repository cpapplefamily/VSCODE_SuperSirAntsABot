package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;


import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Set_Gyro;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_11_1_Start_Left_Deliver_IF_Lswitch_Lscale extends CommandGroup {

    public Auto_11_1_Start_Left_Deliver_IF_Lswitch_Lscale() {
    	addSequential(new Drive_Set_Gyro(0.0),1);
    	addSequential(new Auto_11_2_Conditional_IsSwitch_L());  
    }
}
