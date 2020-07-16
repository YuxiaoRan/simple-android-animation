package com.example.animation_demo

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {

    private var timeInput: Long = 0
    private val animatorSet: AnimatorSet = AnimatorSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        start.setOnClickListener {
            if(validateTimeInput())
                playAnimators()
        }

        stop.setOnClickListener {
            stopAnimators()
        }
    }

    private fun validateTimeInput(): Boolean {
        try {
            timeInput = time.text.toString().toLong()
            return true
        } catch (e: Exception) {
            Toast.makeText(this, "Invalid time was input!", Toast.LENGTH_SHORT).show()
            return false
        }
    }

    private fun stopAnimators() {
        animatorSet.cancel()
    }

    private fun playAnimators() {
        val blackScaleX: ObjectAnimator = ObjectAnimator.ofFloat(
            objblack, "scaleX", 0.5f, 1.5f).apply {
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            duration = timeInput
        }

        val blackScaleY: ObjectAnimator = ObjectAnimator.ofFloat(
            objblack, "scaleY", 0.5f, 1.5f).apply {
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            duration = timeInput
        }

        val blackAlpha: ObjectAnimator = ObjectAnimator.ofFloat(
            objblack, "alpha", 1.0f, 0f).apply {
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            duration = timeInput
        }

        val pinkScaleX: ObjectAnimator = ObjectAnimator.ofFloat(
            objpink, "scaleX", 0.5f, 1.5f).apply {
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            duration = timeInput
        }

        val pinkScaleY: ObjectAnimator = ObjectAnimator.ofFloat(
            objpink, "scaleY", 0.5f, 1.5f).apply {
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            duration = timeInput
        }

        val pinkAlpha: ObjectAnimator = ObjectAnimator.ofFloat(
            objpink, "alpha", 0f, 1.0f).apply {
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            duration = timeInput
        }

        animatorSet.apply {
            playTogether(blackScaleX, blackScaleY, blackAlpha, pinkScaleX, pinkScaleY, pinkAlpha)
            start()
        }
    }
}