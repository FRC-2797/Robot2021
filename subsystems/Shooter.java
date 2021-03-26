package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants.ShooterConst;

public class Shooter extends SubsystemBase{
    Double gameData;
    double timed = .5;
    //boolean pressed;
    public Timer timer = new Timer();

    private final WPI_VictorSPX flywheel = new WPI_VictorSPX(3);
    private final WPI_VictorSPX windowMotor = new WPI_VictorSPX(5);
    private final WPI_VictorSPX intake = new WPI_VictorSPX(1);
    
    private final CANSparkMax shooterMotor = new CANSparkMax(1 , MotorType.kBrushless);
    
    
    
    public void shoot(double speed){
        flywheel.set(-speed);
        shooterMotor.set(-speed);
    }

    public void stop(){
        flywheel.disable();
        shooterMotor.stopMotor();
    }

    public void intakeStop(){
        intake.stopMotor();
    }

    public void retract(double speed){
        shooterMotor.set(-speed);
    }

    public void intake(double speed){
        intake.set(speed);
    }

    public void revWindow(double speed){
        windowMotor.set(-speed);
    }
    
    public void windowUp(double speed){
        //TODO: Change to do while if it works
        timer.start();
        while(timer.get() < 3){
            windowMotor.set(speed);

        }
    }

    public void windowStop(){
        windowMotor.stopMotor();
    }

    public void timedShoot(double speed){
        timer.start();

        //TODO: while loop slowing down all other functions 

        do{
            shooterMotor.set(speed);
        }
        while(timer.get() < timed);

        shooterMotor.set(speed);
        flywheel.set(speed);
    }

}