// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;
import frc.robot.Constants.MotorConstants;

public class RollerSubsystem extends SubsystemBase {
  private final SparkMax roller1 = new SparkMax(CanIds.ROLLER_1_ID, MotorType.kBrushless);
  private final SparkMax roller2 = new SparkMax(CanIds.ROLLER_2_ID, MotorType.kBrushless);

  public RollerSubsystem() {
    roller1.setInverted(MotorConstants.ROLLER_1_INVERTED);
    roller2.setInverted(MotorConstants.ROLLER_2_INVERTED);
  }

  public void setRoller1(double speed) {
    roller1.set(speed);
  }

  public void setRoller2(double speed) {
    roller2.set(speed);
  }

  public void stop() {
    roller1.stopMotor();
    roller2.stopMotor();
  }
}
