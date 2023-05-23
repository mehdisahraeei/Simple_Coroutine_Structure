package com.mahdi.coroutines


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {


    suspend fun method1()
    {
        delay(1000L)
        Log.i("hello","${Thread.currentThread().name}")
    }



    suspend fun method2()
    {
        delay(1000L)
        Log.i("hello","${Thread.currentThread().name}")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GlobalScope.launch(Dispatchers.Default) {

            method1()
            method2()

            withContext(newSingleThreadContext("yummy"))
            {
                delay(2000L)
                Log.i("hello","${Thread.currentThread().name}")
            }

        }


        Log.i("hello","${Thread.currentThread().name}")




    }
}