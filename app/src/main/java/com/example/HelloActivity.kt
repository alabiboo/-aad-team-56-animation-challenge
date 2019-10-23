package com.example

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HelloActivity : AppCompatActivity() {

    private var ball: ImageView? = null
    private var desc: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        ball = findViewById<ImageView>(R.id.helloImg)
        desc = findViewById<TextView>(R.id.desText)
        val btnAnime : Button = findViewById<Button>(R.id.btnAnime)
        val btnAnime2 : Button = findViewById<Button>(R.id.btnAnime2)
        val btnAnime3 : Button = findViewById<Button>(R.id.btnAnime3)

        btnAnime.setOnClickListener {
            if (ball != null) {
                ball!!.visibility = View.VISIBLE
                rotateb()
            }


    }
        btnAnime2.setOnClickListener {
            if (desc != null) {
                desc!!.visibility = View.VISIBLE
                combin_anims()
            }
        }

        btnAnime3.setOnClickListener {
            val intent = Intent(this, AlbActivity::class.java)
            startActivity(intent)
        }
    }


    private fun translate() {
        val ty1 = ObjectAnimator.ofFloat(ball, View.TRANSLATION_Y, 0f, 200f)
        ty1.setDuration(1000)
        ty1.interpolator = BounceInterpolator()
        ty1.start()
    }

     private   fun rotateb() {
            val rotate = ObjectAnimator.ofFloat(ball, View.ROTATION, -360f, 0f)
            rotate.setDuration(1000)
            rotate.interpolator = AccelerateInterpolator()
            rotate.start()
        }

    private fun fade() {
        val fade = ObjectAnimator.ofFloat(ball, View.ALPHA, 0.2f, 1.0f)
        fade.setDuration(1000)
        fade.start()
    }

    private fun scale() {
        val anims = AnimatorSet();
        val sX = ObjectAnimator.ofFloat(ball, View.SCALE_X, 0.2f, 1.0f)
        val sY = ObjectAnimator.ofFloat(ball, View.SCALE_Y, 0.2f, 1.0f)
        anims.playTogether(sX, sY)
        anims.interpolator = AccelerateInterpolator()
        anims.start()
    }

    private fun combin_anims() {

        val anims1 = AnimatorSet()
        val sX = ObjectAnimator.ofFloat(desc, View.SCALE_X, 0.2f, 1.0f)
        val sY = ObjectAnimator.ofFloat(desc, View.SCALE_Y, 0.2f, 1.0f)
        val fade = ObjectAnimator.ofFloat(desc, View.ALPHA, 0.2f, 1.0f)

        anims1.playTogether(sX, sY, fade)
        anims1.setDuration(600)

        val anims2 = AnimatorSet()

        val tx1 = ObjectAnimator.ofFloat(desc, View.TRANSLATION_Y, 0f, 200f)
        tx1.setDuration(1000)
        tx1.interpolator = BounceInterpolator()

        val rotate = ObjectAnimator.ofFloat(desc, View.ROTATION, -360f, 0f)
        rotate.setDuration(1000)
        rotate.interpolator = AccelerateInterpolator()

        anims2.playTogether(tx1, rotate)

        val final_anim = AnimatorSet();

        final_anim.play(anims1).before(anims2)
        final_anim.play(anims2)

        final_anim.addListener(object: Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
            }

        });

        final_anim.start()

    }

    }
