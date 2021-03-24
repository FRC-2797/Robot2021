package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveSeconds;
import frc.robot.commands.Intake;
import frc.robot.commands.StrafeDistance;
import frc.robot.commands.StrafeSeconds;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class GalacticGroup extends SequentialCommandGroup{
    
    double speed = .5;
    double distance;
    public GalacticGroup(Drivetrain drivetrain, Shooter intake, boolean path, boolean color){
        //Path A
        if(path = true){
            if(color = true){
                //red
                addCommands(
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 2.49: 1.245, drivetrain, speed),
                        new Intake(intake)
                    ),
                    //TODO: TEST STRAFE SEONDS AND REPLACE ALL NUMBERS AND MAKE THE TING GO NEGATIVE WOWOWOWOWOWOWOOWOWOW
                    new StrafeSeconds(drivetrain, (speed == .5) ? 1 : 1, speed),
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 1.66 : .83, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new StrafeDistance(drivetrain, (speed == .5)? -1 : 2, -speed),
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? .83 : .415, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new DriveSeconds((speed == .5 ? 4.98 : 2.49), drivetrain, speed)
                );
            }
            else{
                addCommands(
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 4.98 : 2.49, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new StrafeDistance(drivetrain, (speed == .5) ? 1 : 2, -speed),
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? .83 : .415, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new StrafeDistance(drivetrain, (speed == .5) ? 1 : 2, speed),
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 1.66 : .83, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new DriveSeconds((speed == .5) ? 1.66 : .83, drivetrain, speed)
                );

            }
        }
        else{
            //red
            if(color = true){
                addCommands(
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 2.49 : 1.245, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new StrafeDistance(drivetrain, (speed == .5) ? 1 : 2, speed),
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 1.66 : .83, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new StrafeDistance(drivetrain, (speed == .5) ? 1 : 2, -speed),
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 1.66 : .83, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new DriveSeconds((speed == .5) ? 3.32 : 1.66, drivetrain, speed)
                );
            }
            //blue
            else{
                addCommands(
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 4.98 : 2.49, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new StrafeDistance(drivetrain, (speed == .5) ? 1 : 2, -speed),
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 1.66 : .83, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new StrafeDistance(drivetrain, (speed == .5) ? 1 : 2, speed),
                    new ParallelCommandGroup(
                        new DriveSeconds((speed == .5) ? 1.66 : .83, drivetrain, speed),
                        new Intake(intake)
                    ),
                    new DriveSeconds((speed == .5) ? .83 : .415, drivetrain, speed)
                );
            }
        }
        
    }
    
}
