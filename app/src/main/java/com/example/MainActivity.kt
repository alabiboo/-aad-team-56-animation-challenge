package com.example

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), Animator.AnimatorListener {

	private var rotateAnimator: ObjectAnimator? = null
	private var translateAnimator: ObjectAnimator? = null
	private var scaleAnimator: ObjectAnimator? = null
	private var fadeAnimator: ObjectAnimator? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

	}

	fun rotateAnimation(view: View) {

		rotateAnimator = ObjectAnimator.ofFloat(targetImage, "rotation", 0.0f, -180.0f)
		rotateAnimator?.apply {
			duration = 1000
			repeatCount = 1
			repeatMode = ValueAnimator.REVERSE
			addListener(this@MainActivity)
			start()
		}
	}

	fun scaleAnimation(view: View) {

		scaleAnimator = ObjectAnimator.ofFloat(targetImage, "scaleX", 1.0f, 3.0f)
		scaleAnimator?.apply {
			duration = 1000
			repeatCount = 1
			repeatMode = ValueAnimator.REVERSE
			addListener(this@MainActivity)
			start()
		}
	}

	fun translateAnimation(view: View) {

		translateAnimator = ObjectAnimator.ofFloat(targetImage, "translationX", 0f, 200f)
		translateAnimator?.apply {
			duration = 1000
			repeatCount = 1
			repeatMode = ValueAnimator.REVERSE
			addListener(this@MainActivity)
			start()
		}

		// translateAnimator.cancel()
	}

	fun fadeAnimation(view: View) {

		fadeAnimator = ObjectAnimator.ofFloat(targetImage, "alpha", 1.0f, 0.0f)
		fadeAnimator?.apply {
			duration = 1500
			repeatCount = 1
			repeatMode = ValueAnimator.REVERSE
			addListener(this@MainActivity)
			start()
		}
	}

	// Implementation of AnimatorListener interface
	override fun onAnimationStart(animation: Animator?) {

		if (animation == scaleAnimator)
			Toast.makeText(this, "Scale Animation Started", Toast.LENGTH_SHORT).show()

		if (animation == rotateAnimator)
			Toast.makeText(this, "Rotate Animation Started", Toast.LENGTH_SHORT).show()

		if (animation == translateAnimator)
			Toast.makeText(this, "Translate Animation Started", Toast.LENGTH_SHORT).show()

		if (animation == fadeAnimator)
			Toast.makeText(this, "Fade Animation Started", Toast.LENGTH_SHORT).show()
	}

	override fun onAnimationRepeat(animation: Animator?) {

		Toast.makeText(this, "Animation Repeated", Toast.LENGTH_SHORT).show()
	}

	override fun onAnimationEnd(animation: Animator?) {

		Toast.makeText(this, "Animation Ended", Toast.LENGTH_SHORT).show()
	}

	override fun onAnimationCancel(animation: Animator?) {

		Toast.makeText(this, "Animation Cancelled", Toast.LENGTH_SHORT).show()
	}

	fun setFromXML(view: View) {

		val animator = AnimatorInflater.loadAnimator(this, R.animator.set)
		animator.apply {
			setTarget(targetImage)
			start()
		}
	}

	fun setFromCode(view: View) {

	}
}
