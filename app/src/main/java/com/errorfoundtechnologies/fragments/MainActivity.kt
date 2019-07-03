package com.errorfoundtechnologies.fragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var isFragmentFirstLoaded= true
    val manager =supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ShowFirstFragment()
        bt1.setOnClickListener {
            if (isFragmentFirstLoaded){
                ShowSecondFragment()
            }
            else
              ShowFirstFragment()
        }


    }

    fun ShowFirstFragment(){
        val transaction = manager.beginTransaction()
        val fragment = FirstFragment()
        transaction.replace(R.id.frame_layout_1,fragment)
        transaction.commit()
        isFragmentFirstLoaded=true
    }

    fun ShowSecondFragment(){
        val transaction = manager.beginTransaction()
        val fragment = SecondFragment()
        transaction.replace(R.id.frame_layout_1,fragment)
        transaction.commit()
        isFragmentFirstLoaded=false
    }

}
