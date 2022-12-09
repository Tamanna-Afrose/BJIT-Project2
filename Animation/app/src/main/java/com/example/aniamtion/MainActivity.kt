package com.example.aniamtion


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //private lateinit var buttonOne:Button
    private lateinit var buttontwo:Button
    private lateinit var imageStar:ImageView
    private lateinit var stick:ImageView
    private lateinit var truck:ImageView
    private lateinit var blinkText:TextView
    private lateinit var ball:ImageView
    private lateinit var bullet:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //buttonOne= findViewById(R.id.button1)
        buttontwo= findViewById(R.id.button2)
        stick=findViewById(R.id.stick)
        imageStar=findViewById(R.id.star)
        truck=findViewById(R.id.truck)
        blinkText=findViewById(R.id.blinkText)
        ball=findViewById(R.id.ball)
        bullet=findViewById(R.id.bullet)

        /*buttonOne.setOnClickListener {
            val animation = ObjectAnimator.ofFloat(text, View.ROTATION, 0f,360f)
            animation.repeatCount=5
            animation.duration=500
            animation.repeatMode= ValueAnimator.REVERSE
            animation.start()

        }*/
        buttontwo.setOnClickListener {
            val slideAnimation= AnimationUtils.loadAnimation(this,R.anim.slide)
            truck.startAnimation(slideAnimation)
            Handler(Looper.getMainLooper()).postDelayed(
                {  val rotateAnimation= AnimationUtils.loadAnimation(this,R.anim.rotation_star)
                    imageStar.startAnimation(rotateAnimation)
                    Handler(Looper.getMainLooper()).postDelayed(
                        { val rotationStick= AnimationUtils.loadAnimation(this,R.anim.rotation)
                            stick.startAnimation(rotationStick)
                            Handler(Looper.getMainLooper()).postDelayed(
                                { val ballAnimation= AnimationUtils.loadAnimation(this,R.anim.ball_animation)
                                    ball.startAnimation(ballAnimation)
                                    Handler(Looper.getMainLooper()).postDelayed(
                                        {
                                            val bulletAnimation= AnimationUtils.loadAnimation(this,R.anim.bullet_animation)
                                            bullet.startAnimation(bulletAnimation)
                                            Handler(Looper.getMainLooper()).postDelayed(
                                                { val blinkAnimation=AnimationUtils.loadAnimation(this,R.anim.blink)
                                                    blinkText.startAnimation(blinkAnimation)
                                                },1500)
                                        },2000)
                                },2500)
                        }, 1000 )
                },
                2000
            )
        }
        }

    }
