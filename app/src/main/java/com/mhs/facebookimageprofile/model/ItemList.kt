package com.mhs.facebookimageprofile.model

import android.os.Parcel
import android.os.Parcelable

data class ItemList(
    var ItemID :Int = 0,
    var ItemName:String = "",
    var Images :ArrayList<ItemImage> = ArrayList()
):Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readValue(ArrayList::class.java.classLoader) as ArrayList<ItemImage>
    ) {
        ItemID = parcel.readInt()
        ItemName = parcel.readString()!!
        Images =  parcel.readValue(ArrayList::class.java.classLoader) as ArrayList<ItemImage>
    }



    override fun describeContents(): Int {
        return  0
    }

    override fun writeToParcel(dest: Parcel, p1: Int) {
        dest.writeInt(ItemID)
        dest.writeString(ItemName)
        dest.writeValue(Images)
    }

    companion object CREATOR : Parcelable.Creator<ItemList> {
        override fun createFromParcel(parcel: Parcel): ItemList {
            return ItemList(parcel)
        }

        override fun newArray(size: Int): Array<ItemList?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "ItemList{" +
                "IID=" + ItemID +
                ", ItemName='" + ItemName + '\'' +
                ", Images=" + Images +
                '}'
    }
}