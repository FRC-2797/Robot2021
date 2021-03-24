package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Drivetrain;

public class TurnToAngleProfiled extends PIDCommand{
    //TODO: must test, probably wont work
    public TurnToAngleProfiled(double targetDegrees, Drivetrain drive){
        super(new PIDController(0.0, 0.0, 0.0), 
            drive::getHeading, 
            targetDegrees, 
            output -> drive.drive(0.0, 0.0, output, false), 
            drive);
        
        getController().enableContinuousInput(-180, 180);
        getController().setTolerance(2,2);

        System.out.println("Test");
    }

    @Override
    public boolean isFinished(){
        return getController().atSetpoint();
    }
}