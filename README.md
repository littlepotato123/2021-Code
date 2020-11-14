## Team 15200
# Research
    Servo: {
        Creating Servo: {
            public Servo (whatever name of servo);
            (whatever name of servo) = hardwareMap.get(Servo.class, "Name of Whatever servo you are using"); // Configure in the phone
        }

        Getting Servo Position: {
            double servopositionnow = (whatever name of servo).getPosition() // Returns a double
        }

        Setting Servo Position: {
            (whatever name of servo).setPosition(double); // Moves the Servo
        }
    }

     Motor: {
        Creating Motor: {
            public DcMotor (whatever name of motor) = null; // Null --> Nothing
            (whatever name of motor) = hardwareMap.get(DcMotor.class, "Name of whatever motor you are using"); // Configure in phone
        }

        Getting Motor Position: {
            int motorpositionnow = (whatever name of motor).getCurrentPosition(); // Return a double
        }

        Setting Motor Direction: {
            (whatever name of motor).setDirection(DcMotor.Direction.(FORWARD or REVERSE));
        }

        Setting Motor Speed: {
            (whatever name of motor).setPower(double);
        }

        Setting Motor Distance: {
            (whatever name of motor).setTargetPosition(int);
        }

        Setting Motor Mode: {
            (whatever name of motor).setMode(Dc.RunMode.(AnyMode)); // All Modes --> https://ftctechnh.github.io/ftc_app/doc/javadoc/com/qualcomm/robotcore/hardware/DcMotor.RunMode.html
        }

        isBusy: {
            Check if the motor is moving
            (whatever name of motor).isBusy();
        }
    }

    TeleOp: {
        double (whatever the name of the function for) = gamepad.stick_x or stick_y // You can do the same thing with gamepad 1 and 2
        There is also gamepad1.a, gamepad.b, gamepad.x, gamepad.y, gamepad.left_trigger, gamepad.right_trigger // You can do the same thing with gamepad 1 and 2
        All of these return doubles and you can check, if a button is clicked it returns a boolean
        A trigger returns a double, and if clicked it is above 0.1
        A stick returns a double, and based on how far you push the joystick
    }

## Planning
    Processes
        Intake/Ejection: {
            1) Moving the Roller --> Pull the Disk into the robot
            2) Moving two Motors (Rods) --> Drag the Disk up to drop into the storage box
            3) Tilt the storage box a little (Powerful Servo) --> To line up the ejection and storage box
            4) Moves the Blue Rod (Powerful Servo) --> To push the disks into the ejection area
            5) Moving One Motor --> Ejection Wheel Pushing It Out
        }

        Extra: {
            1) Ejection Wheel has two modes

- One is medium power for medium level goal
                \- Second is high power for highest goal
        }

        Claw: {
                                                       Pickup Disk

  - Move Servo --> Push the Disk into the claw and lock claw

                                                       Pickup Wobbler

    - Move Servo --> Enclose the claw so that the wobbler cannot escape
                                                           \- Move Motor --> Flip the Wobbler
                                                           \- Unflip the Wobbler Outside the Ring
                                                   }

                                                   Direction/Moving: {
                                                       \- Diagonal Movement
                                                       \- Use Last Year's Movement
                                                   }

                                               Programming
                                                   Vision: {
                                                       Scan for 0, 1, or 4 rings
                                                       0 --> Zone A
                                                       1 --> Zone B
                                                       4 --> Zone C
                                                   }
                                                   Files: {
                                                       DRobotClass.java - All the servos and motors of the robot inside of one object & basic functions for autonomous
                                                       DTeleOpClass.java - Driving and Controlling the robot through gamepads
                                                       DRobotUtil.java - Measurements and Conversions of the field and different objects
                                                       DRobotVisionAnalyze.java - Initializing Vuforia and Analyzing The Field
                                                   }

                                           # Thought Process
                                               1) The first part of programming that came in mind while planning out how to program was the research. Once we were done with the research we made a quick description for each motor, each function, and what their purpose was.
                                               2) Once that was done, we quickly finished the DRobotClass with all of the main methods and properties that our robot needed and we would use in TeleOp and Autonomous.
                                               3) We also realized that none of the values could be set in stone, especially now since we cannot test the program as easily, so we created a class for the values that we would use continuously like the VUFORIA key, motor speeds, and ejection time.
                                               3) After we finished the DRobotClass we went to TeleOp because that was extremely easy since all we had to do was use the methods that we had to make for the robot, and trigger them once a gamepad button was created.
                                               4) Once we were done with TeleOp and DRobotClass, we started changing a few parts of the DRobotClass, mainly the directional aspect, not rotation because we wanted to try something new. Instead of having several functions for moving in different angles, we could build one function, that could move in any direction (Even Diagonal)
                                               5) After the changes, we started researching on how Vuforia works and how we could implement it in our code, how we could use it in Autonomous and how we could implement Vuforia in to our robot as a whole. This includes the camera, phone, and the position of the Objects.

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
                                               10) Diagonal: GamePad1 Right Stick (X-Axis/Y-Axis)
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
