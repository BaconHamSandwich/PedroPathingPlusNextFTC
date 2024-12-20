package org.firstinspires.ftc.teamcode.nextFTCTesting.examplebucketautojava;

import com.qualcomm.robotcore.hardware.Servo;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.ftc.OpModeData;
import com.rowanmcalpin.nextftc.ftc.hardware.ServoToPosition;

public class GrabSubsystem implements Subsystem {

    private static GrabSubsystem instance;

    private double closedClawPos = 0.25;
    private double openClawPos = 0.0;

    private Servo grab;

    private GrabSubsystem() {

    }

    public static GrabSubsystem getInstance() {
        if (instance == null) {
            instance = new GrabSubsystem();
        }

        return instance;
    }

    public Command openClaw() {
        return new ServoToPosition(grab, openClawPos, getInstance());
    }

    public Command closeClaw() {
        return new ServoToPosition(grab, closedClawPos, getInstance());
    }

    @Override
    public void initialize() {
        grab = OpModeData.INSTANCE.getHardwareMap().get(Servo.class, "grab");
    }
}
