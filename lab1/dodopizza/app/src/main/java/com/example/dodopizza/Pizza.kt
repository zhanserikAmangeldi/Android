package com.example.dodopizza

import android.os.Parcel
import android.os.Parcelable

data class Pizza(var pizza_image: Int, var name: String?, var description: String?, var price: String?, var subDescription: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(pizza_image)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(price)
        parcel.writeString(subDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pizza> {
        override fun createFromParcel(parcel: Parcel): Pizza {
            return Pizza(parcel)
        }

        override fun newArray(size: Int): Array<Pizza?> {
            return arrayOfNulls(size)
        }
    }
}
