package org.usfirst.frc3244.SuperSirAntsABot2.commands;



import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive_Tracking_Target extends Command {

	float Kp = 0.01f;
	
    public Drive_Tracking_Target() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.limeLighttable.getEntry("camMode").setValue(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double m_x = 0.0;
    	double m_y = 0.0;
    	double m_currentRotationRate = Robot.vision_hardware.my_degRotationToTarget()*Kp;
    	
    	
    	SmartDashboard.putNumber("Drive Rotation to Target", m_currentRotationRate);
    	Robot.drive.mecanumDriveAutoInTeleop(m_x, m_y, m_currentRotationRate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// note:  it is important to call mecanumDriveCartesian here, rather than mecanumDriveAutonomous,
    	// to ensure that "heading preservation" isn't activated for the last instruction
    	Robot.drive.mecanumDriveAutoInTeleopFinished();
    	Robot.drive.mecanumDriveCartesian(0.0, 0.0, 0.0);
    	Robot.limeLighttable.getEntry("camMode").setValue(1);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
