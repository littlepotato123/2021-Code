package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.CameraDevice;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.threads.AfterABlue;
import org.firstinspires.ftc.teamcode.threads.AfterBBlue;
import org.firstinspires.ftc.teamcode.threads.AfterCBlue;
import org.firstinspires.ftc.teamcode.threads.Autonomous_Init;
import org.firstinspires.ftc.teamcode.threads.Blue1A;
import org.firstinspires.ftc.teamcode.threads.Blue1B;
import org.firstinspires.ftc.teamcode.threads.Blue1C;
import org.firstinspires.ftc.teamcode.threads.FailureBlue1;

import java.util.ArrayList;
import java.util.List;

import static org.firstinspires.ftc.teamcode.DRobotUtil.VUFORIA_KEY;

@Autonomous(name="Autonomous Blue 1", group="Concept")
public class DAutonomousBlue1 extends LinearOpMode {
    public static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = VuforiaLocalizer.CameraDirection.BACK;
    private static final boolean PHONE_IS_PORTRAIT = true;

    private OpenGLMatrix lastLocation = null;

    private Stack stack;
    private boolean targetVisible;
    private float phoneXRotate = 0;
    private float phoneYRotate = 0;
    private float phoneZRotate = 0;

    public DRobotClass robot = new DRobotClass();

    int cameraMonitorViewId;
    public VuforiaLocalizer vuforia;
    public VuforiaTrackables disks;
    public List<VuforiaTrackable> allTrackables;
    public VuforiaLocalizer.Parameters parameters;
    public VuforiaTrackable zero_stack, one_stack, four_stack;

    public enum Stack {
        ZERO,
        ONE,
        FOUR
    };

    // Thread Variables
    public Autonomous_Init init = new Autonomous_Init();
    public Blue1A a = new Blue1A();
    public Blue1B b = new Blue1B();
    public Blue1C c = new Blue1C();
    public AfterABlue aa = new AfterABlue();
    public AfterBBlue ab = new AfterBBlue();
    public AfterCBlue ac = new AfterCBlue();
    public FailureBlue1 f = new FailureBlue1();

    public void Initialize_Autonomous() {
        robot.Initialize_Autonomous_Robot(hardwareMap);

        cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CAMERA_CHOICE;

        vuforia = ClassFactory.getInstance().createVuforia(parameters);
        vuforia.enableConvertFrameToBitmap();

        CameraDevice.getInstance().setFlashTorchMode(true);
    }

    public void Initialize_Vuforia_Trackables() {
        disks = this.vuforia.loadTrackablesFromAsset("StonesAndChips");

        zero_stack = disks.get(0);
        zero_stack.setName("Zero Stack");
        one_stack = disks.get(1);
        one_stack.setName("One Stack");
        four_stack = disks.get(2);
        four_stack.setName("Four Stack");

        allTrackables = new ArrayList<VuforiaTrackable>;
        allTrackables.addAll(disks);

        if(CAMERA_CHOICE == VuforiaLocalizer.CameraDirection.BACK) {
            phoneYRotate = -90;
        } else {
            phoneYRotate = 90;
        }

        if(PHONE_IS_PORTRAIT) {
            phoneXRotate = 90;
        }
    }

    @Override
    public void runOpMode() {
        Position pos = new Position();
        VectorF translation = null;
        Initialize_Autonomous();
        Initialize_Vuforia_Trackables();

        disks.activate();
        pos.x = 0;
        pos.y = 0;
        pos.z = 0;

        waitForStart();

        // Move Robot To Precise Location (Use Thread)
        init.run();

        sleep(200); // Figure out how long

        targetVisible = false;
        while((!targetVisible) && (pos.y >= -17)) {
            for(VuforiaTrackable trackable: allTrackables) {
                if(((VuforiaTrackableDefaultListener) trackable.getListener()).isVisible()) {
                    if(trackable.getName() == "Zero Stack") {
                        targetVisible = true;
                        stack = Stack.ZERO;
                    } else if(trackable.getName() == "One Stack") {
                        targetVisible = true;
                        stack = Stack.ONE;
                    } else if(trackable.getName() == "Four Stack") {
                        targetVisible = true;
                        stack = Stack.FOUR;
                    }
                }
            }
        }

        switch(stack) {
            case ZERO:
                a.run();
                aa.run();
            case ONE:
                b.run();
                ab.run();
            case FOUR:
                c.run();
                ac.run();
        }

        if(!targetVisible) {
            f.run();
        }

        idle();
        disks.deactivate();
    }
}