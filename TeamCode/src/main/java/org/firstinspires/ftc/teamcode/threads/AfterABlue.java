package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class AfterABlue extends Thread {
    public DRobotClass robot = new DRobotClass();
    public Ejection_High ejection = new Ejection_High();
    public Ejection_PowerShot power_shot = new Ejection_PowerShot();

    @Override
    public void run() {
        robot.Any_Directional_Movement(26, Math.sqrt(5));
        ejection.run();
        power_shot.run();
    }
}