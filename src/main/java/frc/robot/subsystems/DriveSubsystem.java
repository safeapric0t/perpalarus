// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.MotorConstants;

public class DriveSubsystem extends SubsystemBase {
  private final SparkMax leftTank1 = new SparkMax(CanIds.LEFT_TANK_1_ID, MotorType.kBrushless);
  private final SparkMax leftTank2 = new SparkMax(CanIds.LEFT_TANK_2_ID, MotorType.kBrushless);
  private final SparkMax rightTank1 = new SparkMax(CanIds.RIGHT_TANK_1_ID, MotorType.kBrushless);
  private final SparkMax rightTank2 = new SparkMax(CanIds.RIGHT_TANK_2_ID, MotorType.kBrushless);

  private final DifferentialDrive differentialDrive =
      new DifferentialDrive(this::setLeftMotors, this::setRightMotors);

  public DriveSubsystem() {
    leftTank1.setInverted(MotorConstants.LEFT_TANK_1_INVERTED);
    leftTank2.setInverted(MotorConstants.LEFT_TANK_2_INVERTED);
    rightTank1.setInverted(MotorConstants.RIGHT_TANK_1_INVERTED);
    rightTank2.setInverted(MotorConstants.RIGHT_TANK_2_INVERTED);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(
        leftSpeed * DriveConstants.MAX_DRIVE_SPEED,
        rightSpeed * DriveConstants.MAX_DRIVE_SPEED);
  }

  public void stop() {
    differentialDrive.stopMotor();
  }

  private void setLeftMotors(double speed) {
    leftTank1.set(speed);
    leftTank2.set(speed);
  }

  private void setRightMotors(double speed) {
    rightTank1.set(speed);
    rightTank2.set(speed);
  }
}
