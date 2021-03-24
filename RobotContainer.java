/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commandGroups.GalacticGroup;
import frc.robot.commands.DriveSeconds;
import frc.robot.commands.TurnToAngleProfiled;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final Drivetrain drivetrain = new Drivetrain();
  public static XboxController xbx = new XboxController(0);
  public static final Limelight limelight = new Limelight();
  public static final Shooter shooter = new Shooter();
  public static TurnToAngleProfiled profiledTurn;
  public static final ColorSensor colorsensor = new ColorSensor();

  private final Command driveSec = new DriveSeconds(10, drivetrain, .5);  
  
  //path A Red
  private final Command galacticSearchAR = new GalacticGroup(drivetrain, shooter, true, true);
  //path A Blue
  private final Command galacticSearchAB = new GalacticGroup(drivetrain, shooter, true, false);
  //path B Red
  private final Command galacticSearchBR = new GalacticGroup(drivetrain, shooter, false, true);
  //path B Blue
  private final Command galacticSearchBB = new GalacticGroup(drivetrain, shooter, false, false);
  
  SendableChooser<Command> chooser = new SendableChooser<>();
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  @SuppressWarnings("PMD.ExcessiveImports")
  public RobotContainer(){
    // Configure the button bindings
    configureButtonBindings();
    //shooter.setDefaultCommand(new RunCommand() -> shooter.shoot);
    
    chooser.setDefaultOption("Galactic Search A Red", galacticSearchAR);
    chooser.addOption("Galactice Search A Blue", galacticSearchAB);
    chooser.addOption("Galactice Search B Red", galacticSearchBR);
    chooser.addOption("Galactice Search B Blue", galacticSearchBB);

    //TODO: Test this woo
    SmartDashboard.putData("Autonomous", chooser);


    drivetrain.setDefaultCommand(
      new RunCommand(() -> drivetrain.drive(
        (xbx.getPOV() == -1)?0:((xbx.getPOV() == 90 )?0.5:-0.5),
        -(xbx.getY(GenericHID.Hand.kLeft) > 0.3?xbx.getY(GenericHID.Hand.kLeft):xbx.getY(GenericHID.Hand.kLeft)< -0.3?xbx.getY(GenericHID.Hand.kLeft):0),
        xbx.getX(GenericHID.Hand.kRight) > 0.3?xbx.getX(GenericHID.Hand.kRight):xbx.getX(GenericHID.Hand.kRight)<-0.3?xbx.getX(GenericHID.Hand.kRight):0, false),drivetrain));
    /*
    shooter.setDefaultCommand(
      new RunCommand(() -> shooter.timedShoot((
        xbx.getTriggerAxis(GenericHID.Hand.kRight) > 0.1)?1:((xbx.getTriggerAxis(GenericHID.Hand.kLeft) > 0.1)?-1:0)), shooter));
    
    colorsensor.setDefaultCommand(
      new RunCommand(() -> colorsensor.distanceSpin((xbx.getPOV() == -1)?0:((xbx.getPOV() == 180)?1:-1), true))
    );

    colorsensor.setDefaultCommand(
      new RunCommand(() -> colorsensor.run((xbx.getPOV() == -1)?0:((xbx.getPOV() == 1)?1:-1),true)));
    */    
      /*
    shooter.setDefaultCommand(new RunCommand(() -> shooter.shoot(xbx.getTriggerAxis(GenericHID.Hand.kRight)), shooter));
    shooter.setDefaultCommand(new RunCommand(() -> shooter.intake(xbx.getTriggerAxis(GenericHID.Hand.kRight)), shooter));

    colorsensor.setDefaultCommand(new RunCommand(() -> colorsensor.distanceSpin(xbx.getPOV() == 0), colorsensor));
    colorsensor.setDefaultCommand(new RunCommand(() -> colorsensor.run(xbx.getPOV() == 2), colorsensor));
    */
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {


    new JoystickButton(xbx, Button.kB.value).whileHeld(() -> shooter.windowUp(1)).whenReleased(() -> shooter.windowStop());

    new JoystickButton(xbx, Button.kA.value).whileHeld(() -> shooter.shoot(1)).whenReleased(() -> shooter.stop());

    //new JoystickButton(xbx, Button.kY.value).whileHeld(() -> colorsensor.spin()).whenReleased(() -> colorsensor.stop());

    new JoystickButton(xbx, Button.kX.value).whileHeld(() -> shooter.intake(.9)).whenReleased(() -> shooter.intakeStop());

    new JoystickButton(xbx, Button.kBumperLeft.value).whileHeld(() -> shooter.revWindow(1)).whenReleased(() -> shooter.windowStop());

    //new JoystickButton(xbx, Button.kY.value).whenPressed(() -> new TurnToAngleProfiled(90, drivetrain));    
    
    new JoystickButton(xbx, 6)
        .whenPressed(() -> drivetrain.setMaxOutput(.2))
        .whenReleased(() -> drivetrain.setMaxOutput(1));

    new JoystickButton(xbx, Button.kY.value).whileHeld(() -> driveSec.execute());

    /*
    new JoystickButton(xbx, Button.kX.value).whenPressed(new PIDCommand(
      new PIDController(0.5,0.0, 0.0), 
      drivetrain::getHeading,
      limelight.getX(), 
      output -> drivetrain.drive(0, 0, output, false), //drivetrain.drive(0, Limelight.distance, 0, false),
      drivetrain));
    

    /*
    new JoystickButton(xbx, Button.kY.value).whenHeld(new PIDCommand(
      new PIDController(0.0, 0.0, 0.0), 

      drivetrain::getHeading,

      0.0, 

      output -> drivetrain.drive(0, 0, limelight.getX(), false),

      drivetrain
    ));

    //new JoystickButton(xbx, Button.kB.value).whenHeld(new TurnToAngle(drivetrain));
}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomouss
   */
  }

  public Command getAutonomousCommand(){
    return chooser.getSelected();
  }

}
