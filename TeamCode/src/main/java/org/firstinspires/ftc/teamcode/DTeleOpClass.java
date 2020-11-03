package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Basic:DTeleOp", group = "Linear Opmode")
public class DTeleOpClass extends LinearOpMode {

    // Declare Timer
    private ElapsedTime timer = new ElapsedTime();

    public DRobotClass robot = new DRobotClass();
    double powerMultiplier = 1;

    public double calculateAngle(double x, double y) {
        double angle = 0;
        double quotient = x/y;
        angle = Math.atan(quotient) * (180/Math.PI);
        return angle;
    }

    @Override
    public void runOpMode() {
        robot.Initialize_TeleOp_Robot(hardwareMap);

        waitForStart();

        timer.reset();

        while (opModeIsActive()) {
            double direction_x = gamepad1.right_stick_x;
            double direction_y = gamepad1.right_stick_y;
            double rotation_x = gamepad1.left_stick_x;
            double rotation_y = gamepad1.left_stick_y;
            double intake_trigger = gamepad2.right_trigger;
            double ejection_trigger = gamepad2.left_trigger;

            if(gamepad2.a) {
                robot.Lever_Action();
            }

            if(gamepad2.b) {
                robot.Rotate_Storage_Box();
            }

            if(gamepad2.x) {
                robot.Open_ClawServo();
            }

            if(gamepad2.y) {
                robot.Close_ClawServo();
            }

            // Ejection Wheel
            while(ejection_trigger > 0.2) {
                robot.Ejection();
                // Sleep for Time Intervals?
            }

            // Intake
            while(intake_trigger > 0.2) {
                robot.Intake();
                // Sleep for Time Intervals?
            }

            while(direction_x > 0 || direction_y > 0) {
                robot.Any_Directional_Movement(calculateAngle(direction_x, direction_y), 1); // Figure Out Distance When Testing
            }

            while(rotation_x > 0 || rotation_y > 0) {
                robot.turnClock_Autonomous_Robot(calculateAngle(rotation_x, rotation_y));
            }
        }
    }
}