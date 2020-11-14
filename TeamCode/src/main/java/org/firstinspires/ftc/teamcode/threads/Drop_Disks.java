package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Drop_Disks extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.SetEjection_Low();
        robot.Lever_Action();
        robot.Ejection();
        robot.Lever_Action();
        robot.Ejection();
        robot.Lever_Action();
        robot.Ejection();
    }
}
