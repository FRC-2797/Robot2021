package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class StrafeSeconds extends CommandBase{
    private final Drivetrain drivetrain;
    private final double m_seconds;
    private final double m_speed;
    private final Timer timer = new Timer();

    public StrafeSeconds(Drivetrain drive, double seconds, double speed){
        drivetrain = drive;
        m_seconds = seconds;
        m_speed = speed;
        addRequirements(drivetrain);
    }
    @Override
    public void initialize(){
        timer.reset();
        drivetrain.drive(0, m_speed, 0, false);
        System.out.println("init");
    }
 
    @Override
    public void execute(){
        while(timer.get() <= m_seconds){
            drivetrain.drive(0, m_speed, 0, false);
        }
        
    }
 
    @Override
    public void end(boolean interrupted){
        drivetrain.drive(0, 0, 0, false);
        System.out.println("end");
    }
    
    @Override
    public boolean isFinished(){
        //return Math.abs(drive.getEncoder()>= m_distance);
        return timer.get() >= m_seconds;
    }
    
}
