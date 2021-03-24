package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends CommandBase{
    
    private final Drivetrain drive;
    private final double m_distance;
    private final double m_speed;
    /*
    //navx distance not encoder 
    //private double wheelCircumference = 18.85;

    public DriveDistance(boolean forward, double goalPosition, Drivetrain drivetrain){
        super((sim) -> drivetrain.driveDistanceSide(goalPosition, drivetrain), drivetrain);

    }

   public DriveDistance(double goalPosition, Drivetrain drivetrain){
        super(() -> drivetrain.driveDistanceFWD(goalPosition, drivetrain), drivetrain);
        System.out.println("Test ets test etsetsetsee");
   }
   */

   public DriveDistance(double goalPosition, Drivetrain drivetrain, double speed){
       m_distance = goalPosition;
       drive = drivetrain;
       m_speed = speed;
       addRequirements(drive);
   }

   @Override
   public void initialize(){
       drive.resetSensor();
       drive.drive(m_speed, 0, 0, false);
       System.out.println("init");
   }

   @Override
   public void execute(){
       drive.drive(m_speed, 0, 0, false);
       System.out.println("exec");
   }

   @Override
   public void end(boolean interrupted){
       drive.drive(0, 0, 0, false);
       System.out.println("end");
   }
   
   @Override
   public boolean isFinished(){
       //return Math.abs(drive.getEncoder()>= m_distance);
       return Math.abs(drive.getEncoder()) >= m_distance;
   }
   
}