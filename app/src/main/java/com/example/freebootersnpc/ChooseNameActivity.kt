package com.example.freebootersnpc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose_name.*

class ChooseNameActivity : AppCompatActivity() {

    lateinit var quickNPC : NPC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_name)

        quickNPC = intent.getParcelableExtra(EXTRA_NPC)!!

        var arrMotivationGood = resources.getStringArray(R.array.arrMotivationGood)
        var arrMotivationLawful = resources.getStringArray(R.array.arrMotivationLawful)
        var arrMotivationNeutral = resources.getStringArray(R.array.arrMotivationNeutral)
        var arrMotivationChaotic =  resources.getStringArray(R.array.arrMotivationChaotic)
        var arrMotivationEvil = resources.getStringArray(R.array.arrMotivationEvil)

        quickNPC.motivation = when(quickNPC.alignment) {
            "good" -> quickNPC.roll1d12(arrMotivationGood)
            "lawful" -> quickNPC.roll1d12(arrMotivationLawful)
            "neutral" -> quickNPC.roll1d12(arrMotivationNeutral)
            "chaotic" -> quickNPC.roll1d12(arrMotivationChaotic)
            "evil" -> quickNPC.roll1d12(arrMotivationEvil)
            else -> "something wrong"
        }

        quickNPC.virtues = when(quickNPC.alignment) {
            "good" -> 3
            "lawful" -> 2
            "neutral" -> 1
            "chaotic" -> 1
            "evil" -> 0
            else -> 0
        }

        quickNPC.vices = when(quickNPC.alignment) {
            "good" -> 0
            "lawful" -> 1
            "neutral" -> 1
            "chaotic" -> 2
            "evil" -> 3
            else -> 0
        }

        var arrVirtues = resources.getStringArray(R.array.arrVirtues)
        var arrVices = resources.getStringArray(R.array.arrVices)

        quickNPC.virtue = quickNPC.rollTraits(quickNPC.virtues, arrVirtues)
        quickNPC.vice = quickNPC.rollTraits(quickNPC.vices, arrVices)

        resultAlignmentTV.setText(quickNPC.alignment)
        resultHeritageTV.setText(quickNPC.heritage)
        resultGenderTV.setText(quickNPC.gender)
        resultOccupationTV.setText(quickNPC.occupation)

        resultMotivationTV.setText(quickNPC.motivation)

        resultVirtueTV.setText(quickNPC.virtue)
        resultViceTV.setText(quickNPC.vice)

        saveNameBtn.setOnClickListener {
            quickNPC.NPCname = editTextNPCName.text.toString()
            startNextActivity()
        }
    }

    private fun startNextActivity() {
        val finalIntent = Intent(this, FinalActivity::class.java)
        finalIntent.putExtra(EXTRA_NPC, quickNPC)
        startActivity(finalIntent)
    }
}