// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static final Drivetrain drivetrain = new Drivetrain();
  public static XboxController xbx = new XboxController(0);

  public static final Shooter shooter = new Shooter();

  public static final Arm arm = new Arm();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    drivetrain.setDefaultCommand(
      new RunCommand(() -> drivetrain.drive(
        (xbx.getPOV() == -1)?0:((xbx.getPOV() == 90)?0.5:-0.5),
        -(xbx.getY(GenericHID.Hand.kLeft) > 0.3?xbx.getY(GenericHID.Hand.kLeft):xbx.getY(GenericHID.Hand.kLeft)< -0.3?xbx.getY(GenericHID.Hand.kLeft):0),
        xbx.getX(GenericHID.Hand.kRight) > 0.3?xbx.getX(GenericHID.Hand.kRight):xbx.getX(GenericHID.Hand.kRight)<-0.3?xbx.getX(GenericHID.Hand.kRight):0, false), drivetrain));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(xbx, Button.kY.value).whenPressed(() -> shooter.shoot(1)).whenReleased(() -> shooter.stop());

    new JoystickButton(xbx, Button.kA.value).whenPressed(() -> arm.extend()).whenReleased(() -> arm.retract());



  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}
