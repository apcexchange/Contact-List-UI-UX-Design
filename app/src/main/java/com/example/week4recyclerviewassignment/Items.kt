package com.example.week4recyclerviewassignment

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes


class Items(
    @DrawableRes var photos:Int,
    var people:String?,
    var number: String?,
    var email: String?
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(photos)
        parcel.writeString(people)
        parcel.writeString(number)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Items> {
        override fun createFromParcel(parcel: Parcel): Items {
            return Items(parcel)
        }

        override fun newArray(size: Int): Array<Items?> {
            return arrayOfNulls(size)
        }
    }

}

