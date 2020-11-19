package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Red2A extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Open_ClawServo();
    }
}
