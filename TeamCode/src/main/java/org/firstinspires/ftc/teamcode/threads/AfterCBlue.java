package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class AfterCBlue extends Thread {
    public DRobotClass robot = new DRobotClass();
    public Ejection_PowerShot power_shot = new Ejection_PowerShot();
    public Ejection_High ejection = new Ejection_High();

    @Override
    public void run() {
        robot.turnClock_Autonomous_Robot(90);
        robot.Any_Directional_Movement(270, 160);
        ejection.run();
        power_shot.run();
    }
}
