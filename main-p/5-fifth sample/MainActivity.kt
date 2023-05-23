package com.mahdi.coroutines


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var job = CoroutineScope(Dispatchers.Default).launch {


            supervisorScope {
                Log.i("hello" , "${Thread.currentThread().name}")
            }

            async {
                Log.i("hello" , "${Thread.currentThread().name}")
            }

        }



        Log.i("hello" , "${Thread.currentThread().name}")



        runBlocking {
            job.join()
            Log.i("hello" , "yep")
        }





    }
}