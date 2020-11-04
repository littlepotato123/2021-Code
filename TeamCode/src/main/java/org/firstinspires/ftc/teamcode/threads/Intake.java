package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Intake extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Intake();
    }
}
