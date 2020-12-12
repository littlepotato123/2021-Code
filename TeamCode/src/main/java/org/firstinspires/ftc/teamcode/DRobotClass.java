package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

import static org.firstinspires.ftc.teamcode.DRobotUtil.COUNTS_PER_INCH;
import static org.firstinspires.ftc.teamcode.DRobotUtil.COUNTS_PER_MOTOR_REV_LIFT;
import static org.firstinspires.ftc.teamcode.DRobotUtil.EJECTION_TIME;
import static org.firstinspires.ftc.teamcode.DRobotUtil.INTAKE_TIME;
import static org.firstinspires.ftc.teamcode.DRobotUtil.MOTOR_RADIUS;
import static org.firstinspires.ftc.teamcode.DRobotUtil.MOTOR_SPEED;
import static org.firstinspires.ftc.teamcode.DRobotUtil.ROBOT_WIDTH_INCHES;
import static org.firstinspires.ftc.teamcode.DRobotUtil.TURN_SPEED;

public class DRobotClass {
    // Motors
    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftRear;
    public DcMotor rightRear;
    public DcMotor intakeMotor;
    public DcMotor intakeRods;
    public DcMotor ejectionWheel;
    public DcMotor clawMotor;

    // Servos
    public Servo clawServo;
    public Servo lever;
    public Servo storage_rotation;
    public Servo ejection_rotation;

    // Robot Position
    public Position robotCurrentPos;

    public Position getCurrentRobotPosition() {
        return robotCurrentPos;
    }

    public void setRobotPosition(Position pos) {
        robotCurrentPos = pos;
    }

    public void Initialize_TeleOp_Robot(HardwareMap hwMap) {
        leftFront = hwMap.get(DcMotor.class, "left_front");
        rightFront = hwMap.get(DcMotor.class, "right_front");
        leftRear = hwMap.get(DcMotor.class, "left_rear");
        rightRear = hwMap.get(DcMotor.class, "right_rear");
        intakeMotor = hwMap.get(DcMotor.class, "intake_motor");
        intakeRods = hwMap.get(DcMotor.class, "intake_rods");
        ejectionWheel = hwMap.get(DcMotor.class, "ejection_wheel");
        clawMotor = hwMap.get(DcMotor.class, "claw_motor");

        clawServo = hwMap.get(Servo.class, "claw_servo");
        lever = hwMap.get(Servo.class, "lever");
        storage_rotation = hwMap.get(Servo.class, "storage_servo");
        ejection_rotation = hwMap.get(Servo.class, "ejection_rotation");

        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.FORWARD);
        rightRear.setDirection(DcMotor.Direction.REVERSE);
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        ejectionWheel.setDirection(DcMotor.Direction.REVERSE);
        intakeRods.setDirection(DcMotor.Direction.FORWARD);
        clawMotor.setDirection(DcMotor.Direction.FORWARD);
        // Setting Direction of Motors
        // FORWARD --> Clockwise
        // REVERSE --> Counter Clockwise

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeRods.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ejectionWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        clawMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Encoder keeps track of how many times a motor rotates, and can be used for telling a motor to go to a certain postion

        lever.setPosition(0.2); // Find Actual Servo Position during Testing
        clawServo.setPosition(0); // Find Actual Servo Position during Testing
        storage_rotation.setPosition(0);
        ejection_rotation.setPosition(0);
    }

    public void Initialize_Autonomous_Robot(HardwareMap hwMap) {
        leftFront = hwMap.get(DcMotor.class, "left_front");
        rightFront = hwMap.get(DcMotor.class, "right_front");
        leftRear = hwMap.get(DcMotor.class, "left_rear");
        rightRear = hwMap.get(DcMotor.class, "right_rear");
        intakeMotor = hwMap.get(DcMotor.class, "intake_motor");
        intakeRods = hwMap.get(DcMotor.class, "intake_rods");
        ejectionWheel = hwMap.get(DcMotor.class, "ejection_wheel");
        clawMotor = hwMap.get(DcMotor.class, "claw_motor");

        clawServo = hwMap.get(Servo.class, "claw_servo");
        lever = hwMap.get(Servo.class, "lever");
        storage_rotation = hwMap.get(Servo.class, "storage_servo");
        ejection_rotation = hwMap.get(Servo.class, "ejection_rotation");

        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.FORWARD);
        rightRear.setDirection(DcMotor.Direction.REVERSE);
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        ejectionWheel.setDirection(DcMotor.Direction.REVERSE);
        intakeRods.setDirection(DcMotor.Direction.REVERSE);
        clawMotor.setDirection(DcMotor.Direction.FORWARD);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeRods.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ejectionWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        clawMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lever.setPosition(0.2); // Find Actual Servo Position during Testing
        clawServo.setPosition(0); // Find Actual Servo Position during Testing
        storage_rotation.setPosition(0);
        ejection_rotation.setPosition(0);
    }

    // Push Lever and Disk Function
    public void Lever_Action() {
        storage_rotation.setPosition(0.8);
        lever.setPosition(0.8); // Find Servo Position during Testing
        lever.setPosition(0.2); // Find Servo Position during Testing
        storage_rotation.setPosition(0);
    }

    // Open Claw
    public void Open_ClawServo() {
        clawServo.setPosition(0.8); // Find Actual Servo Position during Testing
    }

    // Close Claw
    public void Close_ClawServo() {
        clawServo.setPosition(0); // Find Actual Servo Position during testing
    }

    public void SetEjection_High() {
        ejection_rotation.setPosition(0.8); // Find Real Position during Testing
    }

    public void SetEjection_PowerShot() {
        ejection_rotation.setPosition(0.5); // Find real position during testing
    }

    public void SetEjection_Low() {
        ejection_rotation.setPosition(0.2); // Find real position during testing
    }

    // Rotate Claw Motor
    public void Rotate_Claw_Motor(double rotation) {
        if(clawMotor.isBusy()) {
            // We are already moving the claw
        } else {
            int currentencoder = 0, newencoder=0;
            currentencoder = clawMotor.getCurrentPosition();
            double counts_perinch = COUNTS_PER_MOTOR_REV_LIFT/(2*3.1415926*MOTOR_RADIUS);
            newencoder = currentencoder + (int)(counts_perinch * rotation);

            clawMotor.setTargetPosition(newencoder);
            clawMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            clawMotor.setPower(MOTOR_SPEED);
        }
    }

    // Ejection
    public void Ejection() {
        int currentencoder = 0, newencoder=0;
        currentencoder = ejectionWheel.getCurrentPosition();
        double counts_perinch = COUNTS_PER_MOTOR_REV_LIFT/(2*3.1415926*MOTOR_RADIUS);
        newencoder = currentencoder + (int)(counts_perinch * EJECTION_TIME);

        ejectionWheel.setTargetPosition(newencoder);
        ejectionWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ejectionWheel.setPower(MOTOR_SPEED); // Maybe create a different value for ejection wheel if too slow
    }

    // Intake
    public void Intake() {
        int intakeencoder = 0, newintakeencoder = 0;
        int rodencoder = 0, newrodencoder = 0;
        intakeencoder = intakeMotor.getCurrentPosition();
        rodencoder = intakeRods.getCurrentPosition();

        double counts_perinch = COUNTS_PER_MOTOR_REV_LIFT/(2*3.1415926*MOTOR_RADIUS);
        newintakeencoder = intakeencoder + (int)(counts_perinch * INTAKE_TIME);
        newrodencoder = rodencoder + (int)(counts_perinch * INTAKE_TIME);

        intakeMotor.setTargetPosition(newintakeencoder);
        intakeRods.setTargetPosition(newrodencoder);

        intakeMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        intakeRods.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        intakeMotor.setPower(MOTOR_SPEED);
        intakeRods.setPower(MOTOR_SPEED);
    }

    // Autonomous Set Power
    public void Set_Autonomous_MotorPower(double leftFrontPower, double rightFrontPower, double leftBackPower, double rightBackPower) {
        leftFront.setPower(leftFrontPower);
        leftRear.setPower(leftBackPower);
        rightFront.setPower(rightFrontPower);
        rightRear.setPower(rightBackPower);
    }

    // TeleOp Set Power
    public void Set_TeleOp_MotorPower(double leftFrontPower, double rightFrontPower, double leftBackPower, double rightBackPower) {
        leftFront.setPower(leftFrontPower);
        leftRear.setPower(leftBackPower);
        rightFront.setPower(rightFrontPower);
        rightRear.setPower(rightBackPower);
    }

    // Turning
    public void turnClock_Autonomous_Robot(double angleDegrees)
    {
        turnClock_Autonomous_Robot(angleDegrees,TURN_SPEED );
    }

    public void turnClock_Autonomous_Robot(double angleDegrees, double motorspeed)
    {
        Position pos=new Position();
        setRobotPosition(pos);
        int newLeftFrontTarget;
        int newRightFrontTarget;
        int newLeftRearTarget;
        int newRightRearTarget;

        newLeftFrontTarget = this.leftFront.getCurrentPosition() + (int) ((3.14159*ROBOT_WIDTH_INCHES*1.44*angleDegrees/360)*COUNTS_PER_INCH);
        newRightFrontTarget = this.rightFront.getCurrentPosition() - (int)((3.14159*ROBOT_WIDTH_INCHES*1.44*angleDegrees/360)*COUNTS_PER_INCH);
        newLeftRearTarget= this.leftRear.getCurrentPosition() + (int )((3.14159*ROBOT_WIDTH_INCHES*1.44*angleDegrees/360)*COUNTS_PER_INCH);
        newRightRearTarget= this.rightRear.getCurrentPosition() - (int) ((3.14159*ROBOT_WIDTH_INCHES*1.44*angleDegrees/360)*COUNTS_PER_INCH);

        leftFront.setTargetPosition(newLeftFrontTarget);
        rightFront.setTargetPosition(newRightFrontTarget);
        leftRear.setTargetPosition(newLeftRearTarget);
        rightRear.setTargetPosition(newRightRearTarget);


        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION );
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION );
        leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION );
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION );

        leftFront.setPower(motorspeed );
        rightFront.setPower(motorspeed );
        leftRear.setPower(motorspeed );
        rightRear.setPower(motorspeed );

        while ((leftFront.isBusy() ) || (rightFront.isBusy() )||(leftRear.isBusy() )||(rightRear.isBusy() ))
        {
            //Hold On
        }
    }

    public void Any_Directional_Movement(double angle, double distance) {
        Any_Direction_Movement(angle, MOTOR_SPEED, distance);
    }

    public void Any_Direction_Movement(double angle, double motorspeed, double distance) {
        double flm, frm, blm, brm;

        double radiandirection = Math.toRadians(angle);

        double v = Math.cos(radiandirection) + Math.sin((radiandirection));
        double u = Math.cos(radiandirection) - Math.sin(radiandirection);

        flm = u * motorspeed;
        frm = v * motorspeed;
        blm = v * motorspeed;
        brm = u * motorspeed;

        // Direction
        double counts_perinch = COUNTS_PER_MOTOR_REV_LIFT/(2*3.1415926*MOTOR_RADIUS);

        int newLeftFrontTarget = this.leftFront.getCurrentPosition() + (int)(counts_perinch * distance);
        int newRightFrontTarget = this.rightFront.getCurrentPosition() + (int)(counts_perinch * distance);
        int newLeftRearTarget = this.leftRear.getCurrentPosition() + (int)(counts_perinch * distance);
        int newRightRearTarget = this.rightRear.getCurrentPosition() + (int)(counts_perinch * distance);

        leftFront.setTargetPosition(newLeftFrontTarget);
        rightFront.setTargetPosition(newRightFrontTarget);
        leftRear.setTargetPosition(newLeftRearTarget);
        rightRear.setTargetPosition(newRightRearTarget);

        Set_Autonomous_MotorPower(flm, frm, blm, brm);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION );
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION );
        leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION );
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION );
    }
}