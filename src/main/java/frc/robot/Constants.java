// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  private Constants() {}

  public static final class CanIds {
    public static final int LEFT_TANK_1_ID = 1;
    public static final int LEFT_TANK_2_ID = 2;
    public static final int RIGHT_TANK_1_ID = 3;
    public static final int RIGHT_TANK_2_ID = 4;

    public static final int INTAKE_ID = 5;
    public static final int FEEDER_ID = 6;
    public static final int SHOOTER_ID = 7;
    public static final int ROLLER_1_ID = 8;
    public static final int ROLLER_2_ID = 9;
  }

  public static final class MotorConstants {
    public static final boolean LEFT_TANK_1_INVERTED = false;
    public static final boolean LEFT_TANK_2_INVERTED = false;
    public static final boolean RIGHT_TANK_1_INVERTED = false;
    public static final boolean RIGHT_TANK_2_INVERTED = false;

    public static final boolean INTAKE_INVERTED = false;
    public static final boolean FEEDER_INVERTED = false;
    public static final boolean SHOOTER_INVERTED = false;
    public static final boolean ROLLER_1_INVERTED = false;
    public static final boolean ROLLER_2_INVERTED = false;
  }

  public static final class ControllerConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0;

    public static final int LEFT_STICK_Y_AXIS = 1;
    public static final int RIGHT_STICK_Y_AXIS = 5;
    public static final int LEFT_TRIGGER_AXIS = 3;
    public static final int RIGHT_TRIGGER_AXIS = 4;

    public static final int APRILTAG_ALIGN_BUTTON = 2;

    public static final boolean LEFT_JOYSTICK_INVERTED = true;
    public static final boolean RIGHT_JOYSTICK_INVERTED = true;

    public static final double DRIVE_DEADBAND = 0.08;
    public static final double TRIGGER_THRESHOLD = 0.5;
  }

  public static final class DriveConstants {
    public static final double MAX_DRIVE_SPEED = 1.0;
  }

  public static final class IntakeConstants {
    public static final double INTAKE_SPEED = 0.6;
    /** Intake direction used during shooting, matching the left-trigger intake direction. */
    public static final double SHOOTING_INTAKE_SPEED = INTAKE_SPEED;
  }

  public static final class FeederConstants {
    public static final double SHOOTING_FEEDER_SPEED = 0.65;
  }

  public static final class ShooterConstants {
    public static final double SHOOTING_SPEED = 0.75;
    public static final double SPINUP_TIME_SECONDS = 1.0;
  }

  public static final class RollerConstants {
    public static final double DEFAULT_ROLLER_1_SPEED = 0.5;
    /** The rollers face each other, so they must run in opposite directions. */
    public static final double DEFAULT_ROLLER_2_SPEED = -DEFAULT_ROLLER_1_SPEED;
  }

  public static final class VisionConstants {
    public static final int[] APRILTAG_WHITELIST = {};
    public static final double APRILTAG_ALIGNMENT_TOLERANCE_DEGREES = 2.0;
    public static final double APRILTAG_ALIGNMENT_SPEED = 0.25;
  }
}
