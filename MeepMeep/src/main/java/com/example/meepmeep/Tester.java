package com.example.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

//Changed to Yoonies path
public class Tester {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 12)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36, -60, Math.toRadians(90)))
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





                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}