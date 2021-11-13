package com.mahdi.coroutines


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {


    suspend fun method1()
    {
        delay(2000L)
        Log.i("hello","${Thread.currentThread().name}")
    }



    suspend fun method2()
    {
        delay(2000L)
        Log.i("hello","${Thread.currentThread().name}")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Log.i("hello","start->   ${Thread.currentThread().name}")


        runBlocking(newSingleThreadContext("ok")) {
            launch {
                method1()
            }

            launch {
                method2()
            }
        }


        Log.i("hello","stop->   ${Thread.currentThread().name}")




    }
}