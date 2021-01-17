package com.example.freebootersnpc

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class NPC(
    var heritage: String,
    var occupation: String,
    var gender: String,
    var alignment: String,
    var motivation: String,
    var virtues: Int,
    var vices: Int,
    var virtue: String,
    var vice: String,
    var NPCname: String
) : Parcelable {

    fun roll1d12 (arrayString: Array<String>) : String {
        var random = Random();
        var result = random.nextInt(arrayString.count())
        return arrayString[result]
    }

    fun roll1d100gender() : String {
        var random1d100 = (0..100).random()
        return when (random1d100) {
            11, 22, 33, 44, 55, 66, 77, 88, 99 -> "nonbinary/androgynous"
            in 0..100 step 2 -> "female"
            in 1..99 step 2 -> "male"
            else -> "something wrong"
        }
    }

    fun rollTraits(int: Int, arr: Array<String>) : String {
        var resultTraits = mutableListOf<String>()
        var random = Random();
        if (int == 0) return "-"
        else {
            while (resultTraits.count() < int) {
                var randomTrait = arr[random.nextInt(arr.count())]
                if (randomTrait !in resultTraits) {
                    resultTraits.add(randomTrait)
                }
            }

        }

        return resultTraits.toString().replace("[", "").replace("]", "")

    }
}