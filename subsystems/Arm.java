package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase{

    private final Solenoid armPistons = new Solenoid(1);

    public void extend(){
        armPistons.set(true);
    }

    public void retract(){
        armPistons.set(false);
    }

    public void toggle(){
        armPistons.set((!armPistons.get()));
    }
}
