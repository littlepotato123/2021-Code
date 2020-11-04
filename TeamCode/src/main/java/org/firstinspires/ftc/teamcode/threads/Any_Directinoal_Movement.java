package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Any_Directinoal_Movement extends Thread {
    public DRobotClass robot = new DRobotClass();

    public void run(double distance, double angle) {
        robot.Any_Directional_Movement(angle, distance);
    }
}