package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Intake extends CommandBase{
    private final Shooter shot;
    private final Timer timer = new Timer();

    public Intake(Shooter shoot){
        shot = shoot;
    }

    @Override
    public void initialize(){
        timer.reset();
    }

    //TODO: Test if it needs to be held for a certain amont of time
    @Override
    public void execute(){
        while(timer.get() <= 2){
            shot.intake(.9);
        }
    }

    @Override
    public void end(boolean interrupted){
        shot.intakeStop();
    }

    @Override
    public boolean isFinished(){
        return timer.get() >= 2;
    }

}