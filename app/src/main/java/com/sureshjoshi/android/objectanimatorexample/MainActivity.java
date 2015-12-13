package com.sureshjoshi.android.objectanimatorexample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.Button;

import com.sureshjoshi.android.objectanimatorexample.util.Utils;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.button_repeat)
    Button mAnimationButton;

    @Bind(R.id.button_persist)
    Button mPersistButton;

    @Bind(R.id.button_random)
    Button mRandomButton;

    private static final int TRANSLATION_DISTANCE_DP = 30;

    @OnClick(R.id.button_repeat)
    void animateButton() {
        final int kAnimationDuration = 750;
        float translationDistancePixels = Utils.convertDpToPixel(TRANSLATION_DISTANCE_DP, this);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mAnimationButton, "translationY", 0, translationDistancePixels);
        animator1.setRepeatCount(0);
        animator1.setDuration(kAnimationDuration);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mAnimationButton, "translationY", translationDistancePixels, -translationDistancePixels);
        animator2.setRepeatCount(Animation.INFINITE);
        animator2.setDuration(kAnimationDuration);
        animator2.setRepeatMode(Animation.REVERSE);

        // Create an animation set to play multiple animations
        // Use .before to ensure the first animation finishes before the second starts
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).before(animator2);
        set.start();
    }

    @OnClick(R.id.button_persist)
    void persistAnimationButton() {
        final int kAnimationDuration = 750;
        float translationDistancePixels = Utils.convertDpToPixel(TRANSLATION_DISTANCE_DP, this);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mPersistButton, "translationY", 0, translationDistancePixels);
        animator1.setRepeatCount(0);
        animator1.setDuration(kAnimationDuration);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mPersistButton, "translationY", translationDistancePixels, -translationDistancePixels);
        animator2.setRepeatCount(5);
        animator2.setDuration(kAnimationDuration);
        animator2.setRepeatMode(Animation.REVERSE);

        // Create an animation set to play multiple animations
        // Use .before to ensure the first animation finishes before the second starts
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).before(animator2);
        set.start();
    }

    Handler mHandler = new Handler();
    Float mLastRandomLocation = 0.0f;

    // Set the animation duration just more than the rate of getting new data in
    // This keeps the movement smooth, otherwise - very jerky
    private static final int ANIMATION_DURATION = 300;
    private static final int DELAY_TIME_MS = 250;

    Runnable mRandomRunnable = new Runnable() {
        @Override
        public void run() {
            Random random = new Random();
            float translationDistancePixels = Utils.convertDpToPixel(TRANSLATION_DISTANCE_DP, MainActivity.this);

            // Pick a random number and scale it between translationDistancePixels up or down
            Float nextLocation = random.nextFloat() * 2 * translationDistancePixels - translationDistancePixels;
            ObjectAnimator animator = ObjectAnimator.ofFloat(mRandomButton, "translationY", mLastRandomLocation, nextLocation);
            mLastRandomLocation = nextLocation;

            animator.setRepeatCount(0); // 0 because this is a one-time value
            animator.setDuration(ANIMATION_DURATION);

            AnimatorSet set = new AnimatorSet();
            set.play(animator);
            set.start();

            // Continue ad infinitum
            mHandler.postDelayed(mRandomRunnable, DELAY_TIME_MS);
        }
    };

    @OnClick(R.id.button_random)
    void randomAnimationButton() {
        // Kick off the randomly generated data runnable
        mHandler.removeCallbacks(mRandomRunnable);
        mHandler.postDelayed(mRandomRunnable, DELAY_TIME_MS);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
