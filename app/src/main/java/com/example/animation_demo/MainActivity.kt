package com.example.animation_demo

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animator = ObjectAnimator.ofFloat(badge, "rotation", 0f, 360f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.RESTART
        animator.interpolator = LinearInterpolator()
        animator.duration = 2000

        val animator2 = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        animator2.setTarget(badge2)

        val scaleXAnim = ObjectAnimator.ofFloat(badge3, "scaleX", 2f, 0.5f)
        scaleXAnim.repeatCount = ValueAnimator.INFINITE
        scaleXAnim.repeatMode = ValueAnimator.REVERSE
        scaleXAnim.interpolator = LinearInterpolator()
        scaleXAnim.duration = 1000

        val scaleYAnim = ObjectAnimator.ofFloat(badge3, "scaleY", 2f, 0.5f)
        scaleYAnim.repeatCount = ValueAnimator.INFINITE
        scaleYAnim.repeatMode = ValueAnimator.REVERSE
        scaleYAnim.interpolator = LinearInterpolator()
        scaleYAnim.duration = 1000

        val animatorShiftX = ObjectAnimator.ofFloat(badge, "translationX", 200f, -200f).apply {
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            duration = 2000
            start()
        }

        val animatorShiftY = ObjectAnimator.ofFloat(badge, "translationY", 200f, -200f).apply {
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            duration = 2000
            start()
        }

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(
            animator,
            animatorShiftX,
            animatorShiftY,
            animator2,
            scaleXAnim,
            scaleYAnim
        )
        animatorSet.start()

        badge.setOnClickListener {
            jumpToMediaPlayer()
        }

        badge3.setOnClickListener {
            jumpToAnimation()
        }
    }

    private fun jumpToMediaPlayer() {
        val i: Intent = Intent(this, MediaPlayerActivity::class.java)
        startActivity(i)
    }

    private fun jumpToAnimation() {
        val j: Intent = Intent(this, AnimationActivity::class.java)
        startActivity(j)
    }
}