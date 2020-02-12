/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.lang.Math;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.WheelDrive;
 

public class SwerveDriveSub extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
    
   */

  private WheelDrive backRight;
  private WheelDrive backLeft;
  private WheelDrive frontRight;
  private WheelDrive frontLeft;
  
    private static final double W = 20;
    private static final double L = 30;

    private static final double FRONT_LEFT_ANGLE_OFFSET = -Math.toRadians(0.0);
    private static final double FRONT_RIGHT_ANGLE_OFFSET = -Math.toRadians(0.0);
    private static final double BACK_LEFT_ANGLE_OFFSET = -Math.toRadians(0.0);
    private static final double BACK_RIGHT_ANGLE_OFFSET = -Math.toRadians(0.0);
  
  public SwerveDriveSub(WheelDrive backRight, WheelDrive backLeft, WheelDrive frontRight, WheelDrive frontLeft)
  {
    this.backRight = backRight;
    this.backLeft = backLeft;
    this.frontRight = frontRight;
    this.frontLeft = frontLeft;
  }

  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }

    public void drive (double x1, double y1, double x2)
    {
      double r = Math.sqrt ((L * L) + (W * W));
      y1 *= -1;

      double a = x1 - x2 * (L / r);
      double b = x1 + x2 * (L / r);
      double c = y1 - x2 * (W / r);
      double d = y1 + x2 * (W / r);

      double backRightSpeed = Math.sqrt ((a * a) + (d * d));
      double backLeftSpeed = Math.sqrt ((a * a) + (c * c));
      double frontRightSpeed = Math.sqrt ((b * b) + (d * d));
      double frontLeftSpeed = Math.sqrt ((b * b) + (c * c));

      double backRightAngle = Math.atan2 (a, d) / Math.PI;
      double backLeftAngle = Math.atan2 (a, c) / Math.PI;
      double frontRightAngle = Math.atan2 (b, d) / Math.PI;
      double frontLeftAngle = Math.atan2 (b, c) / Math.PI;

      backRight.drive (backRightSpeed, backRightAngle);
      backLeft.drive (backLeftSpeed, backLeftAngle);
      frontRight.drive (frontRightSpeed, frontRightAngle);
      frontLeft.drive (frontLeftSpeed, frontLeftAngle);
    }




}
