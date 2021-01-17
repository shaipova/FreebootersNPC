package com.example.freebootersnpc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_alignment.*
import kotlinx.android.synthetic.main.activity_heritage.*
import kotlinx.android.synthetic.main.activity_main.*

class AlignmentActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var quickNPC : NPC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alignment)

        quickNPC = intent.getParcelableExtra(EXTRA_NPC)!!

        val arrOccupation = resources.getStringArray(R.array.arrOccupation)
        val arrOutsiderOccupation = resources.getStringArray(R.array.arrOutsiderOccupation)
        val arrMerchantOccupation = resources.getStringArray(R.array.arrMerchantOccupation)
        val arrCriminalOccupation = resources.getStringArray(R.array.arrCriminalOccupation)
        val arrCommonerOccupation = resources.getStringArray(R.array.arrCommonerOccupation)
        val arrTradespersonOccupation = resources.getStringArray(R.array.arrTradespersonOccupation)
        val arrSecurityOccupation = resources.getStringArray(R.array.arrSecurityOccupation)
        val arrSpecialistOccupation = resources.getStringArray(R.array.arrSpecialistOccupation)
        val arrReligiousOccupation = resources.getStringArray(R.array.arrReligiousOccupation)
        val arrAuthorityOccupation = resources.getStringArray(R.array.arrAuthorityOccupation)


        var categoryOccupation = quickNPC.roll1d12(arrOccupation)
        quickNPC.occupation = when(categoryOccupation) {
            "Outsider" -> quickNPC.roll1d12(arrOutsiderOccupation)
            "Criminal" -> quickNPC.roll1d12(arrCriminalOccupation)
            "Commoner" -> quickNPC.roll1d12(arrCommonerOccupation)
            "Tradesperson" -> quickNPC.roll1d12(arrTradespersonOccupation)
            "Merchant" -> quickNPC.roll1d12(arrMerchantOccupation)
            "Specialist" -> quickNPC.roll1d12(arrSpecialistOccupation)
            "Religious" -> quickNPC.roll1d12(arrReligiousOccupation)
            "Security" -> quickNPC.roll1d12(arrSecurityOccupation)
            "Authority" -> quickNPC.roll1d12(arrAuthorityOccupation)
            else -> "we don't know who you are"
        }

        alignmentBtnGood.setOnClickListener(this)
        alignmentBtnChaotic.setOnClickListener(this)
        alignmentBtnEvil.setOnClickListener(this)
        alignmentBtnLawful.setOnClickListener(this)
        alignmentBtnNeutral.setOnClickListener(this)
    }

    fun startNextActivity() {
        val chooseNameIntent = Intent(this, ChooseNameActivity::class.java)
        chooseNameIntent.putExtra(EXTRA_NPC, quickNPC)
        startActivity(chooseNameIntent)
    }

    override fun onClick(view: View?) {
        val arrLawfulAlignment = resources.getStringArray(R.array.arrLawfulAlignment)
        val arrEvilAlignment = resources.getStringArray(R.array.arrEvilAlignment)
        val arrChaoticAlignment = resources.getStringArray(R.array.arrChaoticAlignment)
        val arrGoodAlignment = resources.getStringArray(R.array.arrGoodAlignment)
        val arrNeutralAlignment = resources.getStringArray(R.array.arrNeutralAlignment)

        if (view != null) {
            when (view.id) {
                alignmentBtnLawful.id -> {
                    quickNPC.alignment = quickNPC.roll1d12(arrLawfulAlignment)
                    startNextActivity()
                }
                alignmentBtnChaotic.id -> {
                    quickNPC.alignment = quickNPC.roll1d12(arrChaoticAlignment)
                    startNextActivity()
                }
                alignmentBtnGood.id -> {
                    quickNPC.alignment = quickNPC.roll1d12(arrGoodAlignment)
                    startNextActivity()
                }
                alignmentBtnEvil.id -> {
                    quickNPC.alignment = quickNPC.roll1d12(arrEvilAlignment)
                    startNextActivity()
                }
                alignmentBtnNeutral.id -> {
                    quickNPC.alignment = quickNPC.roll1d12(arrNeutralAlignment)
                    startNextActivity()
                }
            }
        }
    }
}