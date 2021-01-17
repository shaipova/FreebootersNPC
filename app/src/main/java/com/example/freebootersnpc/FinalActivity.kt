package com.example.freebootersnpc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_final.*

class FinalActivity : AppCompatActivity() {

    lateinit var quickNPC : NPC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        quickNPC = intent.getParcelableExtra(EXTRA_NPC)!!

        NPCinfo.text = "NPC character `s name is ${quickNPC.NPCname}, \n\noccupation: ${quickNPC.occupation}, \n\ngender is ${quickNPC.gender}, " +
                "\n\nalignment: ${quickNPC.alignment}, \n\nmotivation: ${quickNPC.motivation}, \n\nvirtue: ${quickNPC.virtue}, \n\nvice: ${quickNPC.vice}"

        createNewNPCBtn.setOnClickListener {
            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }
    }
}