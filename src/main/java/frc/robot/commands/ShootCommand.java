// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.FeederConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.RollerConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends Command {
  private final ShooterSubsystem shooterSubsystem;
  private final FeederSubsystem feederSubsystem;
  private final IntakeSubsystem intakeSubsystem;
  private final RollerSubsystem rollerSubsystem;
  private final Timer spinupTimer = new Timer();

  public ShootCommand(
      ShooterSubsystem shooterSubsystem,
      FeederSubsystem feederSubsystem,
      IntakeSubsystem intakeSubsystem,
      RollerSubsystem rollerSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    this.feederSubsystem = feederSubsystem;
    this.intakeSubsystem = intakeSubsystem;
    this.rollerSubsystem = rollerSubsystem;
    addRequirements(shooterSubsystem, feederSubsystem, intakeSubsystem, rollerSubsystem);
  }

  @Override
  public void initialize() {
    spinupTimer.restart();
    shooterSubsystem.setSpeed(ShooterConstants.SHOOTING_SPEED);
    feederSubsystem.stop();
    intakeSubsystem.stop();
    rollerSubsystem.stop();
  }

  @Override
  public void execute() {
    shooterSubsystem.setSpeed(ShooterConstants.SHOOTING_SPEED);

    if (spinupTimer.hasElapsed(ShooterConstants.SPINUP_TIME_SECONDS)) {
      rollerSubsystem.setRoller1(RollerConstants.DEFAULT_ROLLER_1_SPEED);
      rollerSubsystem.setRoller2(RollerConstants.DEFAULT_ROLLER_2_SPEED);
      feederSubsystem.setSpeed(FeederConstants.SHOOTING_FEEDER_SPEED);
      intakeSubsystem.setSpeed(IntakeConstants.SHOOTING_INTAKE_SPEED);
    }
  }

  @Override
  public void end(boolean interrupted) {
    spinupTimer.stop();
    shooterSubsystem.stop();
    feederSubsystem.stop();
    intakeSubsystem.stop();
    rollerSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
