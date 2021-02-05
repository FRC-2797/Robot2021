package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants.DriveConst;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{

    private final WPI_TalonFX frontRight = new WPI_TalonFX(DriveConst.FRONTRIGHT);
    private final WPI_TalonFX frontLeft = new WPI_TalonFX(DriveConst.FRONTLEFT);
    private final WPI_TalonFX backLeft = new WPI_TalonFX(DriveConst.BACKLEFT);
    private final WPI_TalonFX backRight = new WPI_TalonFX(DriveConst.BACKRIGHT);

    private static final AHRS gyro = new AHRS();

    private final MecanumDrive drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    public void drive(double ySpeed, double xSpeed, double rot, boolean fieldRelative){
        if(fieldRelative){
            drivetrain.driveCartesian(ySpeed, xSpeed, rot, -gyro.getAngle());
        }else{
            drivetrain.driveCartesian(ySpeed, xSpeed, rot);
        }
    }

    public Rotation2d getAngle(){
        return Rotation2d.fromDegrees(gyro.getAngle() * (DriveConst.gyroReversed ? 1.0: -1.0));
    }

    public void calibrate(){
        gyro.calibrate();
    }

    public static boolean isFinished(){
        return true;
    } 
}