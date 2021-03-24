package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class GamePad extends Button{
    private final int axisNumber;
    private final boolean polarity;
    private final double threshold;

    public GamePad(XboxController xbox, int axis, boolean pol, double thresh){
        RobotContainer.xbx = xbox;
        axisNumber = axis;
        polarity = pol;
        threshold = thresh;
    }

    public GamePad(XboxController xbox, int axis){
        this(xbox, axis, true, 0.5);
    }

    public boolean get(){
        double rawAxis = RobotContainer.xbx.getRawAxis(0);

        if(polarity){
            return(Math.max(rawAxis, 0)> threshold);
        }
        else{
            return(-Math.min(rawAxis, 0) > threshold);
        }
    }
}