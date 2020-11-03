package org.firstinspires.ftc.teamcode;

public class DRobotUtil {
    public static final String TAG= "DRobotUtil";
    public static final float mmPerInch = 25.4f;

    // ROBOT
    static final double ROBOT_WIDTH_INCHES = 200 * mmPerInch; // Find After Building

    // MOTORS
    static final double COUNTS_PER_MOTOR_REV = 1120;
    static final double COUNTS_PER_MOTOR_REV_LIFT = 1440;
    static final double MOTOR_RADIUS = 0.2;
    static final double  WHEELS_DIAMETER_INCHES = 4;
    static final double COUNTS_PER_INCH = COUNTS_PER_MOTOR_REV / (WHEELS_DIAMETER_INCHES *3.14154);
    static final double EJECTION_TIME = 10; // Find Actual Value while Testing
    static final double INTAKE_TIME = 10; // Find Actual Value while Testing

    // SPEED
    static final double MOTOR_SPEED = 0.2;

    // AUTONOMOUS
    static final double AUTONOMOUS_DRIVE_SPEED = 1.0;
    static final double TURN_SPEED = 0.2;

    static final String VUFORIA_KEY = "Ad/bswf/////AAABmS/7F6qJBkqJulPxtf2jXHoIrlKoM7H3DFA9l0NU51OrRSekqZ5TAd7ZBbq3fp8gHWET3C/NiO5jXMY/UQvCQEVGqG8XBVHKYHY7jlZRGkWsSUvnI+fxEr7oi/PKxELoaZreVlV8F7z1KFGPFGpa0miqV7Yv0BtsEI5/5BNIrumoH56p/R80HbzZhrwtGOsS6/ASxH6nfh0Kka4kxaNalIFyuwA+43U7L3/OjmUeLMy2kUZKVqkCLNqIVqfAEODhf4AYgkkGETySoCGqDVQ40Mf8S8lEgCpQviRiukLl+v2yXvwBk6sYucZ6Kp6PGEGLUa/fLBfzq6ro9b2I+2ymqGjd2MRpYuQ2nABViwlVwb7F";
}
