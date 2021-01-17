package com.example.freebootersnpc

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_heritage.*

class HeritageActivity : AppCompatActivity(), View.OnClickListener {

    var quickNPC = NPC("", "", "", "", "", 0, 0, "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heritage)

        quickNPC.gender = quickNPC.roll1d100gender()

        heritageBtnElf.setOnClickListener(this)
        heritageBtnDwarf.setOnClickListener(this)
        heritageBtnHalfling.setOnClickListener(this)
        heritageBtnHuman.setOnClickListener(this)
    }

    fun startNextActivity() {
        val alignmentIntent = Intent(this, AlignmentActivity::class.java)
        alignmentIntent.putExtra(EXTRA_NPC, quickNPC)
        startActivity(alignmentIntent)
    }
    override fun onClick(view: View?) {
        val arrHalflingHeritage = resources.getStringArray(R.array.arrHalflingHeritage)
        val arrElfHeritage = resources.getStringArray(R.array.arrElfHeritage)
        val arrDwarfHeritage = resources.getStringArray(R.array.arrDwarfHeritage)
        val arrHumanHeritage = resources.getStringArray(R.array.arrHumanHeritage)

        if (view != null) {
            when (view.id) {
                heritageBtnDwarf.id -> {
                    quickNPC.heritage = quickNPC.roll1d12(arrDwarfHeritage)
                    startNextActivity()
                }
                heritageBtnElf.id -> {
                    quickNPC.heritage = quickNPC.roll1d12(arrElfHeritage)
                    startNextActivity()
                }
                heritageBtnHalfling.id -> {
                    quickNPC.heritage = quickNPC.roll1d12(arrHalflingHeritage)
                    startNextActivity()
                }
                heritageBtnHuman.id -> {
                    quickNPC.heritage = quickNPC.roll1d12(arrHumanHeritage)
                    startNextActivity()
                }
            }
        }
    }

}