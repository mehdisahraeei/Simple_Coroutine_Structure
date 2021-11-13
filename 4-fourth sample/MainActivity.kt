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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var job = CoroutineScope(Dispatchers.Default).launch {
            repeat(5)
            {
                method1()
            }
        }



        Log.i("hello","start->   ${Thread.currentThread().name}")


        runBlocking {
            delay(3000L)
            job.cancel()

            Log.i("hello","it was canceled")

        }




    }
}