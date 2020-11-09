package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class AfterPark extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.Any_Directional_Movement(90, 15.0);
    }
}
