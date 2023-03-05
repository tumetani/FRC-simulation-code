// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// e import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
// import frc.robot.subsystems.Arm;
// import frc.robot.subsystems.ExampleArmMovement;
import frc.robot.subsystems.IntakeSubsystem;
// import edu.wpi.first.wpilibj.TimedRobot;
// import frc.robot.subsystems.IntakeFunctions;
import frc.robot.subsystems.ArmSubsystem;

public class Robot extends TimedRobot {
    private final Joystick m_joystick = new Joystick(0); // change to the variable from Constants.java

    // private final Arm m_arm = new Arm();
    // private final ExampleArmMovement m_arm_example = new ExampleArmMovement();
    // private final IntakeFunctions intake = new IntakeFunctions();

    @Override
    public void robotInit() {
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
        new RobotContainer();
        if (m_joystick.getRawButton(1)) {
            arm.raise();
            // arm.raiseDebug();
        } else if (m_joystick.getRawButton(2)) {
            arm.lower();
            // arm.lowerDebug();
        } else if (m_joystick.getRawButton(3)) {
            // intake.intake();
        } else {
            // this code should keep current position
            // arm.setSetpoint(arm.getDegrees());
            arm.stop();
            // intake.stop();
        }
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void disabledExit() {
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void autonomousExit() {
    }

    @Override
    public void teleopInit() {
        // m_arm.loadPreferences();
    }



    @Override
    public void simulationPeriodic() {
        // m_arm.simulationPeriodic();
    }
    
    private final ArmSubsystem arm = new ArmSubsystem();
    // private final IntakeSubsystem intake = new IntakeSubsystem();
    double armPositionTriggerStopped = Constants.kMinAngleRads; // default value
    @Override
    public void teleopPeriodic() {
        // if (m_joystick.getRawButton(1)) {
        //     // arm.raise();
        //     arm.raiseDebug();
        // } else if (m_joystick.getRawButton(2)) {
        //     // arm.lower();
        //     arm.lowerDebug();
        // } else if (m_joystick.getRawButton(3)) {
        //     arm.stop();
        //     // intake.intake();
        // } else {
        //     // this code should keep current position
        //     // arm.setSetpoint(arm.getDegrees());
        //     arm.stop();
        //     // intake.stop();
        // }
    }

    @Override
    public void teleopExit() {
    }


    @Override
    public void close() {
        // m_arm.close();
        super.close();
    }

    @Override
    public void disabledInit() {
        // This just makes sure that our simulation code knows that the motor's off.
        arm.stop();
    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {
    }

    @Override
    public void testExit() {
    }
}
