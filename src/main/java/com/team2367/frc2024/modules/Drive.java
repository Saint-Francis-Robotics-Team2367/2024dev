package com.team2367.frc2024.modules;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;


import com.team2367.frc2024.Constants;
import java.util.ArrayList;


public class Drive {
    private CANSparkMax m_leftLead;
    private CANSparkMax m_leftFollow;
    private CANSparkMax m_rightLead;
    private CANSparkMax m_rightFollow;



    ArrayList <CANSparkMax> motorArray = new ArrayList<CANSparkMax>();

    public void Init(int leftLeadID, int leftFollowID, int rightLeadID, int rightFollowID) {
        m_leftLead = new CANSparkMax(leftLeadID, MotorType.kBrushless);
        m_leftFollow = new CANSparkMax(leftFollowID, MotorType.kBrushless);
        m_rightLead = new CANSparkMax(rightLeadID, MotorType.kBrushless);
        m_rightFollow = new CANSparkMax(rightFollowID, MotorType.kBrushless);

        motorArray.add(m_leftLead);
        motorArray.add(m_leftFollow);
        motorArray.add(m_rightLead);
        motorArray.add(m_rightFollow);

        m_leftFollow.follow(m_leftLead);
        m_rightFollow.follow(m_rightLead);

        for (CANSparkMax motor : motorArray) {
            motor.restoreFactoryDefaults();
            motor.setIdleMode(IdleMode.kBrake);
            motor.setSmartCurrentLimit(Constants.driveCurrentLimit);
        }
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
    }


    
}
