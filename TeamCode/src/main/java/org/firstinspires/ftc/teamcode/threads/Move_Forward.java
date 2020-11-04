package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Move_Forward extends Thread {
    public DRobotClass robot = new DRobotClass();

    public void run(double distance) {
        robot.Any_Directional_Movement(90, distance);
    }
}
