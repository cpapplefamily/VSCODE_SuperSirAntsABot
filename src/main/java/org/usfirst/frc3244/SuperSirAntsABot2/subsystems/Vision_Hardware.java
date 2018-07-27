package org.usfirst.frc3244.SuperSirAntsABot2.subsystems;

import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision_Hardware extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private NetworkTable table = Robot.limeLighttable;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double my_degRotationToTarget() {
    	NetworkTableEntry tx = Robot.limeLighttable.getEntry("tx");
    	double x = tx.getDouble(0.0);
    	return x;
    }
    
    public boolean my_IsTargetFound() {
    	NetworkTableEntry tv = table.getEntry("tv");
    	double v = tv.getDouble(0);
    	if (v == 0.0f){
    		return false;
    	}else {
    		return true;
    	}
    }

	public void setCamMode(double camMode) {
		table.getEntry("camMode").setValue(camMode);
		
	}
}

