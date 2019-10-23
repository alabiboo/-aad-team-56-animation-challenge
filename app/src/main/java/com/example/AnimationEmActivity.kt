package com.example

import android.animation.AnimatorInflater
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_em.*


class AnimationEmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_em)


        val  btnMore= findViewById<Button>(R.id.btn_view_more)

        btnMore.setOnClickListener {

            translateAnimation(it)

        }

    }


    fun translateAnimation(view: View) {

        val translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator.apply {
            setTarget(profile_card)
            start()
        }
    }

    fun fadeAnimation(view: View) {

        val fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha)
        fadeAnimator.setTarget(profile_image1)
        fadeAnimator.start()
    }

    fun myAnimation(view: View){




    }
  }