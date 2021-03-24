package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveSeconds;
import frc.robot.subsystems.Drivetrain;

public class SecondsGroup extends SequentialCommandGroup{

    public SecondsGroup(Drivetrain drivetrain){
        addCommands(
            new DriveSeconds(5, drivetrain, .2)
        );
    }
    
}
