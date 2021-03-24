package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class BallGroup extends SequentialCommandGroup{
    /*
    private static int starting;
    private static Alliance team;

    public int setStarting(){
        starting = DriverStation.getInstance().getLocation();
        return starting;
    }

    public Alliance getTeam(){
        team = DriverStation.getInstance().getAlliance();
        return team;
    }

    public BallGroup(Drivetrain drivetrain, Limelight limelight, DriveDistance drive, Shooter shoot){
        if(starting == 1){
            addCommands(
                new ResetEncoder(drivetrain),
                new Shake(drivetrain),
                new ResetEncoder(drivetrain),
                new ParallelCommandGroup(
                    new Intake(shoot),
                    new DriveDistance(300250.0, drivetrain)
                ),
                new ResetEncoder(drivetrain)
            );
        }
        else if(starting ==2){
            addCommands(
                new ResetEncoder(drivetrain),
                new Shake(drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(136000.0, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(true, -161625.0, drivetrain),
                new ResetEncoder(drivetrain),
                new ParallelCommandGroup(
                    new Intake(shoot),
                    new DriveDistance(164750.0, drivetrain)
                ),
                new ResetEncoder(drivetrain)
            );

        }
        if(starting ==3){
            addCommands(
                new ResetEncoder(drivetrain),
                new Shake(drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(136000.0, drivetrain),
                new ResetEncoder(drivetrain),
                //i think this number needs to be more 
                new DriveDistance(true, -323250.0, drivetrain),
                new ResetEncoder(drivetrain),
                new ParallelCommandGroup(
                    new Intake(shoot),
                    new DriveDistance(164750.0, drivetrain)
                ),
                new ResetEncoder(drivetrain)

            );
           

        }        
    }
    */
}