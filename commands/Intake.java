package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Intake extends CommandBase{
    private final Shooter shot;
    public Intake(Shooter shoot){
        shot = shoot;
    }

    //TODO: Test if it needs to be held for a certain amont of time
    @Override
    public void execute(){
        shot.shoot(1);
    }
}