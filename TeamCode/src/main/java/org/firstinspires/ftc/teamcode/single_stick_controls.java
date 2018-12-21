package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//put this in your code.
@TeleOp(name="single stick controls", group="Linear Opmode")
public class single_stick_controls extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.get(DcMotor.class, "motorL");
        rightDrive = hardwareMap.get(DcMotor.class, "motorR");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        while (opModeIsActive()) {
            double leftPower;
            double rightPower;
            double drive = gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;
            if (turn < -0.5) {
                leftPower = -turn;
                rightPower = turn;
                leftDrive.setPower(leftPower);
                rightDrive.setPower(rightPower);
            }
            if (turn > 0.5) {
                rightPower = turn;
                leftPower = -turn;
                leftDrive.setPower(leftPower);
                rightDrive.setPower(rightPower);
            }
            if (turn <= 0.5 && turn >= -0.5) {
                rightPower = -drive;
                leftPower = -drive;
                leftDrive.setPower(leftPower);
                rightDrive.setPower(rightPower);
            }
        }
    }
}