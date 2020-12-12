## Team 15200

# Research
    - Servo
      - Getting Servo Position: (varName).getPosition()
      - Setting Servo Position: (varName).setPosition(double)
    - Motor
      - Getting Motor Position: (varName).getCurrentPosition()
      - Setting Motor Direction: (varName).setDirection(DcMotor.Direction.(Forward | Reverse))
      - Setting Motor Speed: (varName).setPower(double)
      - Setting Motor Distance: (varName).setTargetPosition(int)
      - Setting Motor Mode: (varName).setMode(DcMotor.RunMode.(Modes))
        - All Modes: https://ftctechnh.github.io/ftc_app/doc/javadoc/com/qualcomm/robotcore/hardware/DcMotor.RunMode.html
    - TeleOp Mode (gamepad1 | gamepad2)
      - A, B, X, Y, left_trigger, right_trigger: Return Boolean
        - gamepad1.a (How to retrieve boolean)
      - stick_x, stick_y: Double

# GamePad Bindings
    1) Driving: GamePad1 Left Stick (Y-Axis)
    2) Turning: GamePad1 Left Stick (X-Axis)
    3) Strafe: Gamepad1 Left and Right Triggers
    4) Intake Process: GamePad2 Right Trigger
    5) Ejection Process (Excluding Lever Action)GamePad2 Left Trigger
    6) Lever Process: GamePad2 (Button A)
    7) Rotate Storage Box Process: GamePad2 (Button B)
    8) Open Claw Servo: GamePad2 (Button X)
    9) Close Claw Servo: GamePad2 (Button Y)
    10) Diagonal: GamePad1 Right Stick (X-Axis Y-Axis)

# Autonomous
    1) Drop Wobbler
        - Wobbler Is Already Picked Up
        - Detect How Many Disks are infront
        - Drop Wobbler in corresponding target zone
    2) Regular Ejection
        - Position using Automation (Behind Launch Line)
        - Shoot All 3
    3) If Target Zone is C
        - Drop the Disks in lower goal
# Tasks
    1) AfterBlue.java --> FailureBlue1.java
    2) FailureBlue2.java --> Turn_Clock_270.java