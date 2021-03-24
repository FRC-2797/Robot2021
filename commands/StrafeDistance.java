package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class StrafeDistance extends CommandBase{
    private final Drivetrain drivetrain;
    private final double m_distance;
    private final double m_speed;

    public StrafeDistance(Drivetrain drive, double distance, double speed){
        drivetrain = drive;
        m_distance = distance;
        m_speed = speed;
        addRequirements(drivetrain);
    }
    @Override
    public void initialize(){
        drivetrain.resetSensor();
        drivetrain.drive(0, m_speed, 0, false);
        System.out.println("init");
    }
 
    @Override
    public void execute(){
        drivetrain.drive(0, m_speed, 0, false);
        System.out.println("exec");
    }
 
    @Override
    public void end(boolean interrupted){
        drivetrain.drive(0, 0, 0, false);
        System.out.println("end");
    }
    
    @Override
    public boolean isFinished(){
        //return Math.abs(drive.getEncoder()>= m_distance);
        return Math.abs(drivetrain.getEncoder()) >= m_distance;
    }
    
}
