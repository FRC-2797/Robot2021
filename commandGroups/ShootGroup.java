package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class ShootGroup extends SequentialCommandGroup{
    /*
    private static int starting =1;
    private static Alliance team;

    /*
    public int setStarting(){
        starting = DriverStation.getInstance().getLocation();
        return starting;
    }
    
    public Alliance getTeam(){
        team = DriverStation.getInstance().getAlliance();
        return team;
    }


    public ShootGroup(Drivetrain drivetrain, Limelight limelight, DriveDistance drive, Shooter shoot){
        //written for top
        if(starting == 1){
            addCommands(
                new ResetEncoder(drivetrain),
                new DriveDistance(123000.0, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(true, 66440.0, drivetrain),
                new ResetEncoder(drivetrain),
                //new TurnToAngleProfiled(180.0, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(90000.0, drivetrain),
                new Shoot(shoot, 1)
            );
        }
        //middle
        else if(starting ==2){
            addCommands(
                new ResetEncoder(drivetrain),
                new DriveDistance(150000.0, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(true, -66440.0, drivetrain),
                new ResetEncoder(drivetrain),
                new TurnToAngleProfiled(180.0, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(90000.0, drivetrain),
                new Shoot(shoot, 1)
            );
        }
        //bottom
        else if(starting == 3){
            addCommands(
                new ResetEncoder(drivetrain),
                new DriveDistance(1360000, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(true, -179320.0, drivetrain),
                new ResetEncoder(drivetrain),
                new TurnToAngleProfiled(180, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(90000.0, drivetrain)
            );
        }
    }
    */
}