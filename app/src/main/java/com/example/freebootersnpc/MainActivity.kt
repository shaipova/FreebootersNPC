package com.example.freebootersnpc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heritageIntent = Intent(this, HeritageActivity::class.java)

        quickNPCbtn.setOnClickListener {
            startActivity(heritageIntent)
        }

        detailedNPCbtn.setOnClickListener {
            startActivity(heritageIntent)
        }
    }


}