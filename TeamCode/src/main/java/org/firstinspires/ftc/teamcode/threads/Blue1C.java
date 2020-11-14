package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class Blue1C extends Thread {
    public DRobotClass robot = new DRobotClass();
    public Drop_Disks drop = new Drop_Disks();

    @Override
    public void run() {
        robot.Any_Directional_Movement(90, 150);
        robot.turnClock_Autonomous_Robot(90);
        drop.run();
    }
}