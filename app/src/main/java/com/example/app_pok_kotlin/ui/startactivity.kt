package com.example.app_pok_kotlin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app_pok_kotlin.R
import java.util.concurrent.TimeUnit


class startactivity : AppCompatActivity() {
    var timer: Thread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startactivity)
        timer = object : Thread() {
            override fun run() {
                try {
                    synchronized(this) {
                        TimeUnit.SECONDS.sleep(8L)
                        /*wait(5000)*/
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    val intent = Intent(this@startactivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        (this.timer as Thread).start()

    }
}