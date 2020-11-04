package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Turn_Clock_180 extends Thread {
    public DRobotClass robot = new DRobotClass();

    @Override
    public void run() {
        robot.turnClock_Autonomous_Robot(180);
    }
}
