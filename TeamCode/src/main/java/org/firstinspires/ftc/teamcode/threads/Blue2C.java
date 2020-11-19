package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Blue2C extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Any_Directional_Movement(107, Math.sqrt(109));
        robot.Open_ClawServo();
    }
}
