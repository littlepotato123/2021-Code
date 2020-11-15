package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Red2B extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Any_Directional_Movement(90, 120);
        robot.turnClock_Autonomous_Robot(270);
        robot.Open_ClawServo();
    }
}
