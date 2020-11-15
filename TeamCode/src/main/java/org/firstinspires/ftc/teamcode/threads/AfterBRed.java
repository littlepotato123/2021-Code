package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class AfterBRed extends Thread {
    public DRobotClass robot = new DRobotClass();
    public Ejection_High ejection = new Ejection_High();
    public Ejection_PowerShot power_shot = new Ejection_PowerShot();

    @Override
    public void run() {
        robot.turnClock_Autonomous_Robot(270);
        robot.Any_Directional_Movement(270, 50);
        ejection.run();
        power_shot.run();
    }
}
