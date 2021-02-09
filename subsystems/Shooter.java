package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    
    private final WPI_VictorSPX flywheel = new WPI_VictorSPX(2);
    private final WPI_VictorSPX window = new WPI_VictorSPX(3);
    private final WPI_VictorSPX intake = new WPI_VictorSPX(4);

    private final CANSparkMax shooterMotor = new CANSparkMax(3, MotorType.kBrushless);

    public void shoot(double speed){
        flywheel.set(speed);
        shooterMotor.set(speed);
    }

    public void stop(){
        flywheel.disable();
        shooterMotor.disable();
    }

    public void retract(double speed){
        shooterMotor.set(speed);
    }

    public void intake(double speed){
        intake.set(speed);
    }

    public void windowUp(double speed){
        window.set(speed);
    }
}
