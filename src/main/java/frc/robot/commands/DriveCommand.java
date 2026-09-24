// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
  private final DriveSubsystem driveSubsystem;
  private final Joystick driverController;

  public DriveCommand(DriveSubsystem driveSubsystem, Joystick driverController) {
    this.driveSubsystem = driveSubsystem;
    this.driverController = driverController;
    addRequirements(driveSubsystem);
  }

  @Override
  public void execute() {
    double leftSpeed = driverController.getRawAxis(ControllerConstants.LEFT_STICK_Y_AXIS);
    double rightSpeed = driverController.getRawAxis(ControllerConstants.RIGHT_STICK_Y_AXIS);

    if (ControllerConstants.LEFT_JOYSTICK_INVERTED) {
      leftSpeed = -leftSpeed;
    }

    if (ControllerConstants.RIGHT_JOYSTICK_INVERTED) {
      rightSpeed = -rightSpeed;
    }

    leftSpeed = MathUtil.applyDeadband(leftSpeed, ControllerConstants.DRIVE_DEADBAND);
    rightSpeed = MathUtil.applyDeadband(rightSpeed, ControllerConstants.DRIVE_DEADBAND);

    driveSubsystem.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
  }
}
