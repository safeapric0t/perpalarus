// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;
import frc.robot.Constants.MotorConstants;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX shooterMotor = new TalonFX(CanIds.SHOOTER_ID);

  public ShooterSubsystem() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.MotorOutput.Inverted =
        MotorConstants.SHOOTER_INVERTED
            ? InvertedValue.Clockwise_Positive
            : InvertedValue.CounterClockwise_Positive;
    shooterMotor.getConfigurator().apply(config);
  }

  public void setSpeed(double speed) {
    shooterMotor.set(speed);
  }

  public void stop() {
    shooterMotor.stopMotor();
  }
}
