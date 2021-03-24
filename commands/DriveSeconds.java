package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveSeconds extends CommandBase{
    private final Drivetrain drive;
    private final double m_seconds;
    private final double m_speed;
    private final Timer timer = new Timer();
    
    public DriveSeconds(double seconds, Drivetrain drivetrain, double speed){
        drive = drivetrain;
        m_seconds = seconds;
        m_speed = speed; 
    }

    @Override
    public void initialize(){
        timer.reset();
        drive.drive(m_speed, 0, 0, false);
    }

    @Override
    public void execute(){
        
        timer.start();
        while(timer.get() <= m_seconds){
            //System.out.println(drive.getHeading());
            //TODO: Might have to change this value to have the y in the second idk lets see wooo
            drive.drive(0, m_speed, 0, false);
        }
        timer.stop();
        System.out.println(timer.get());
    }

    @Override
    public void end(boolean interrupted){
        drive.drive(0, 0, 0, false);
        timer.reset();
    }

    @Override 
    public boolean isFinished(){
        //idk what to put here
        return true;
    }
}
