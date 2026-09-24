// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.commands.AlignToAprilTagCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
  private final Joystick driverController =
      new Joystick(ControllerConstants.DRIVER_CONTROLLER_PORT);

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final FeederSubsystem feederSubsystem = new FeederSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final RollerSubsystem rollerSubsystem = new RollerSubsystem();

  public RobotContainer() {
    driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, driverController));
    configureBindings();
  }

  private void configureBindings() {
    new Trigger(
            () ->
                driverController.getRawAxis(ControllerConstants.LEFT_TRIGGER_AXIS)
                    > ControllerConstants.TRIGGER_THRESHOLD)
        .whileTrue(
            Commands.startEnd(
                () -> intakeSubsystem.setSpeed(IntakeConstants.INTAKE_SPEED),
                intakeSubsystem::stop,
                intakeSubsystem));

    new Trigger(
            () ->
                driverController.getRawAxis(ControllerConstants.RIGHT_TRIGGER_AXIS)
                    > ControllerConstants.TRIGGER_THRESHOLD)
        .whileTrue(
            new ShootCommand(
                shooterSubsystem, feederSubsystem, intakeSubsystem, rollerSubsystem));

    new Trigger(
            () -> driverController.getRawButton(ControllerConstants.APRILTAG_ALIGN_BUTTON))
        .whileTrue(new AlignToAprilTagCommand(driveSubsystem));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
