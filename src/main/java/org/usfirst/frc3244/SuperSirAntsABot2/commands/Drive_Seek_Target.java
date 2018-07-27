package org.usfirst.frc3244.SuperSirAntsABot2.commands;



import org.usfirst.frc3244.SuperSirAntsABot2.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive_Seek_Target extends Command {

	private double m_x;
	private double m_y;
	private double m_distance;
	float Kp = 0.01f;
	
	 /**
	  * Drive For Distance at current robot Heading
	  * Added constructor CPA
	  * @param x
	  * @param y
	  * @param distance
	  */
    public Drive_Seek_Target(double x, double y, double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	m_x = x;
    	m_y = y;
    	m_distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.zeroDistanceTraveled();
    	Robot.limeLighttable.getEntry("camMode").setValue(0);
    	Robot.limeLighttable.getEntry("pipeline").setValue(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//double m_x = 0.0;
    	//double m_y = 0.0;
    	double m_currentRotationRate = 0.0;
    	if(Robot.vision_hardware.my_IsTargetFound()) {
    		m_currentRotationRate = Robot.vision_hardware.my_degRotationToTarget()*Kp;
    	}
    	
    	SmartDashboard.putNumber("Drive Rotation to Target", m_currentRotationRate);
    	Robot.drive.mecanumDriveAutoInTeleop(m_x, m_y, m_currentRotationRate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.drive.getDistanceTraveled() >= m_distance);
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
