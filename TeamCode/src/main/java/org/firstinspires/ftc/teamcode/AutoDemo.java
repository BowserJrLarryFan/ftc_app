package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



/*
   POSSIBLE SECURITY ALGORITHM -- if OPENCV doesn't detect the first time, go to middle ball and check its color
*/

@Autonomous(name="AutoBranchTest")

public class AutoDemo extends LinearOpMode {


    DcMotor motorL;
    DcMotor motorR;

    public static int branchPath;

    public void runOpMode() throws InterruptedException{

        motorL = hardwareMap.dcMotor.get("motorL");
        motorR = hardwareMap.dcMotor.get("motorR");
        motorL.setDirection(DcMotorSimple.Direction.REVERSE);

        //branchPath = AutoCVtest.branchPath;
        branchPath = 1;

        waitForStart();


        start();

        if(branchPath == 1){
            branch1();
        } else if(branchPath == 2){
            branch2();
        } else if(branchPath == 3){
            branch3();
        } else {
            branch1();
        }




    }



    public void robotMove(double rightWheel, double leftWheel){
        motorL.setPower(leftWheel);
        motorR.setPower(rightWheel);
    }

    public void robotTurn(double rightWheel, double leftWheel, String direction){
        if(direction.equals("left")){

            motorL.setPower(-leftWheel);
            motorR.setPower(rightWheel);

        } else if(direction.equals("right")){

            motorL.setPower(leftWheel);
            motorR.setPower(-rightWheel);

        } else {

            motorL.setPower(leftWheel);
            motorR.setPower(rightWheel);

        }

    }

    public void robotBrake(){
        motorL.setPower(0);
        motorR.setPower(0);
    }

    public void branch1() {

        try{

            robotMove(0.5,0.5);
            Thread.sleep(2000);

            robotBrake();
            Thread.sleep(100);

            robotTurn(0.5,0.5,"left");
            Thread.sleep(750);

            robotMove(0.5,0.5);
            Thread.sleep(1000);

            robotBrake();
            Thread.sleep(100);

            robotTurn(0.5,0.5,"right");
            Thread.sleep(1000);

            robotBrake();
            Thread.sleep(100);

            robotMove(0.5,0.5);
            Thread.sleep(3000);

            robotBrake();
            Thread.sleep(100);



        }catch(Exception e){

        }

    }

    public void branch2(){

        try{

            robotMove(0.5,0.5);
            Thread.sleep(2000);

            robotBrake();
            Thread.sleep(100);

            robotMove(0.5,0.5);
            Thread.sleep(750);

            robotTurn(0.5,0.5,"left");
            Thread.sleep(500);

            robotBrake();
            Thread.sleep(100);

            robotMove(0.5,0.5);
            Thread.sleep(250);

            robotTurn(0.5,0.5,"left");
            Thread.sleep(750);

            robotBrake();
            Thread.sleep(100);

            robotMove(0.5,0.5);
            Thread.sleep(3000);

            robotBrake();
            Thread.sleep(100);

        }catch(Exception e){

        }
    }

    public void branch3(){

        try{

            robotMove(0.5,0.5);
            Thread.sleep(2000);

            robotBrake();
            Thread.sleep(100);

            robotTurn(0.5,0.5,"right");
            Thread.sleep(250);

            robotBrake();
            Thread.sleep(100);

            robotMove(0.5,0.5);
            Thread.sleep(750);

            robotBrake();
            Thread.sleep(100);

            robotTurn(0.5,0.5,"left");
            Thread.sleep(750);

            robotBrake();
            Thread.sleep(100);

            robotMove(0.5,0.5);
            Thread.sleep(3000);

            robotBrake();
            Thread.sleep(100);

        }catch(Exception e){

        }
    }
}

