package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Ejection_High extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.SetEjection_High();
        robot.Lever_Action();
        robot.SetEjection_High();
        robot.Lever_Action();
        robot.SetEjection_High();
        robot.Lever_Action();
    }
}
