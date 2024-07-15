package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous
public class AutonTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        //changed to YOonies path

        Pose2d startPose = new Pose2d(-36, -60, Math.toRadians(90));

        drive.setPoseEstimate(startPose);
        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(startPose)
                .UNSTABLE_addTemporalMarkerOffset(1, () -> {
                    //move slides up



                })
                //goes forward
                .forward(42)
                //goes to score
                .lineToLinearHeading(new Pose2d(-30,-5,Math.toRadians(45)))

                .UNSTABLE_addTemporalMarkerOffset(0, () -> {

                    // open claw



                })
                .waitSeconds(.5)
                .setReversed(true)

                //goes to stack
                .UNSTABLE_addTemporalMarkerOffset(1,() ->{
                    // lower slides
                })

                .splineToLinearHeading(new Pose2d(-61, -12, Math.toRadians(0)), Math.toRadians(180))

                .UNSTABLE_addTemporalMarkerOffset(1,()->{

                    //close claw

                })
                .waitSeconds(.5)

                .setReversed(false)

                //goes to score
                .UNSTABLE_addTemporalMarkerOffset(1,()->{})

                .splineToLinearHeading(new Pose2d(-30, -5, Math.toRadians(45)), Math.toRadians(45))
                .waitSeconds(.5)
                .setReversed(true)

                //goes to stack
                .splineToLinearHeading(new Pose2d(-61, -12, Math.toRadians(0)), Math.toRadians(180))
                .waitSeconds(.5)
                .setReversed(false)

                //goes to score
                .splineToLinearHeading(new Pose2d(-30, -5, Math.toRadians(45)), Math.toRadians(45))
                .waitSeconds(.5)
                .setReversed(true)

                //goes to stack
                .splineToLinearHeading(new Pose2d(-61, -12, Math.toRadians(0)), Math.toRadians(180))
                .waitSeconds(.5)
                .setReversed(false)

                //goes to score
                .splineToLinearHeading(new Pose2d(-30, -5, Math.toRadians(45)), Math.toRadians(45))
                .waitSeconds(.5)
                .setReversed(true)

                //goes to stack
                .splineToLinearHeading(new Pose2d(-61, -12, Math.toRadians(0)), Math.toRadians(180))
                .waitSeconds(.5)
                .setReversed(false)

                //goes to score
                .splineToLinearHeading(new Pose2d(-30, -5, Math.toRadians(45)), Math.toRadians(45))
                .waitSeconds(.5)
                .setReversed(true)





                .build();

        waitForStart();

        if (!isStopRequested())
            drive.followTrajectorySequence(trajSeq);

    }
}