package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Red2A extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Any_Directional_Movement(90, 90);
        robot.Any_Directional_Movement(0, 50);
        robot.turnClock_Autonomous_Robot(270);
        robot.Open_ClawServo();
    }
}
