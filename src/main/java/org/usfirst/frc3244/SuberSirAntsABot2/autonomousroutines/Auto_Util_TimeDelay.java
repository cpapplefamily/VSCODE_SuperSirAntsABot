package org.usfirst.frc3244.SuberSirAntsABot2.autonomousroutines;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Auto_Util_TimeDelay extends TimedCommand {

	private double m_Timeout;
    public Auto_Util_TimeDelay(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        m_Timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriverStation.reportError("Auto_Util_TimeDelay: " + m_Timeout,false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
