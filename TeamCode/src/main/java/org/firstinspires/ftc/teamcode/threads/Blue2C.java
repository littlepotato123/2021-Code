package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Blue2C extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Any_Directional_Movement(90, 150);
        robot.Any_Directional_Movement(180, 50);
        robot.turnClock_Autonomous_Robot(90);
        robot.Open_ClawServo();
    }
}
