package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;

public class Shoot extends InstantCommand{
    private final Shooter shoot;
    public Shoot(Shooter shooter){
        shoot = shooter;
    }
    //TODO: test if it needs to be held for a certain amount of time, most likely
    @Override
    public void execute(){
        shoot.shoot(1);
    }
}