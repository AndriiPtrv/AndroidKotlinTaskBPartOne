package com.example.androidkotlintaskbpartone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            userTimer(editText.text.toString().toInt())
            editText.isEnabled = false
            button.isEnabled = false
        }
    }

    private fun userTimer(time: Int) {
        var timer = object : CountDownTimer((time * 1000).toLong(), 1000L) {
            override fun onFinish() {
                text.text = "Finish!!!"
                editText.isEnabled = true
                button.isEnabled = true
            }

            override fun onTick(millisUntilFinished: Long) {
                text.text = ((millisUntilFinished / 1000)).toString()
            }
        }
        GlobalScope.launch { timer.start() }
    }
}
