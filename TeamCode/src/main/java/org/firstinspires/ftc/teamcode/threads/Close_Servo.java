package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Close_Servo extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Close_ClawServo();
    }
}
