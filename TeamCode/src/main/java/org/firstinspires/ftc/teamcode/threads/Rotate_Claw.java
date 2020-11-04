package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Rotate_Claw extends Thread {
    public DRobotClass robot = new DRobotClass();

    public void run(double angle) {
        robot.Rotate_Claw_Motor(angle);
    }
}
