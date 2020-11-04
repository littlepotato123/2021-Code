package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Drop_Wobbler extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Close_ClawServo();
    }
}
