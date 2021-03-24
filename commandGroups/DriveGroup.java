package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.ResetEncoder;
import frc.robot.subsystems.Drivetrain;

public class DriveGroup extends SequentialCommandGroup{
    public DriveGroup(Drivetrain drivetrain){
        addCommands(
            new DriveDistance(1000, drivetrain,.2),
            new ResetEncoder(drivetrain)
        );
    }
}