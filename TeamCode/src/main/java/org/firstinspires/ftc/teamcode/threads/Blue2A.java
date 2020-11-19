package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Blue2A extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Any_Directional_Movement(117, Math.sqrt(45));
        robot.Open_ClawServo();
    }
}
