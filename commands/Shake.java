package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drivetrain;

public class Shake extends InstantCommand{
    private final Drivetrain drive;
    public Shake(Drivetrain drivetrain){
        drive = drivetrain;
    }

    @Override
    public void execute(){
        //TODO: really weird might not work, must test
        drive.shake(drive);
    }
}