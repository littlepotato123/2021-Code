package org.firstinspires.ftc.teamcode.threads;

import org.firstinspires.ftc.teamcode.DRobotClass;

public class AfterCBlue extends Thread {
    public DRobotClass robot = new DRobotClass();
    public Ejection_PowerShot power_shot = new Ejection_PowerShot();
    public Ejection_High ejection = new Ejection_High();

    @Override
    public void run() {
        robot.Any_Directional_Movement(225, Math.sqrt(18));
        ejection.run();
        power_shot.run();
    }
}
