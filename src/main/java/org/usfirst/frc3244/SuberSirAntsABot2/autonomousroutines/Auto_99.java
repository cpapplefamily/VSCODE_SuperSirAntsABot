package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import org.usfirst.frc3244.SuperSirAntsABot2.commands.Drive_Set_Gyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_99 extends CommandGroup {

    public Auto_99() {
    	// * not using the Direction Chooser to Buggy addSequential(new Drive_Set_Gyro_Chooser(),1); //Not set
    	addSequential(new Drive_Set_Gyro(0.0),1);
    	addSequential(new Auto_00_Reach_BaseLine());
    }
}
