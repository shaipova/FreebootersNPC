package com.example.freebootersnpc

import android.os.Parcel
import android.os.Parcelable

class NPC() : Parcelable {

    var heritage: String = ""
    var occupation: String = ""
    var gender: String = ""
    var alignment: String = ""
    var motivation: String = ""
    var virtues: Int = 0
    var vices: Int = 0
    var traits: String = ""
    var NPCname: String = ""




    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NPC> {
        override fun createFromParcel(parcel: Parcel): NPC {
            return NPC(parcel)
        }

        override fun newArray(size: Int): Array<NPC?> {
            return arrayOfNulls(size)
        }
    }

}