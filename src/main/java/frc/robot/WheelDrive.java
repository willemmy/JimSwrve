/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANAnalog;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ControlType;
import com.revrobotics.SparkMax;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */


//This is one drive and angle motor and encoder combo unit

public class WheelDrive
{

    private Spark angleMotor;               //PWM
    private CANSparkMax speedMotor;         //CAN
    private AnalogInput encoder;            //Analog
    private CANSparkMax NewAngleMotor;
    


    public WheelDrive(int pangleMotor, int pspeedMotor, int pencoder)
    {

        this.angleMotor = new Spark(pangleMotor);
        this.speedMotor = new CANSparkMax(pspeedMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
        this.encoder = new AnalogInput(pencoder);

        NewAngleMotor = new CANSparkMax(10, CANSparkMaxLowLevel.MotorType.kBrushless);
        CANPIDController controller = NewAngleMotor.getPIDController();
        CANAnalog absencoder = NewAngleMotor.getAnalog(CANAnalog.AnalogMode.kAbsolute);
        
        controller.setFeedbackDevice(absencoder);
        
        controller.setReference(.5, ControlType.kPosition);
    }

    public void drive (double speed, double angle) {
        speedMotor.set (speed);
        
        angleMotor.set(angle);
        
    }




}
