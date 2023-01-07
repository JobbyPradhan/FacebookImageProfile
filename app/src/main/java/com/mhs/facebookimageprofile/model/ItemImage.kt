package com.mhs.facebookimageprofile.model

import android.os.Parcel
import android.os.Parcelable

open class ItemImage : ItemPosition {
    var itemImageId: Int
    var imagePath: String?
    var thumb: String?

    constructor(itemImageId: Int, imagePath: String?, thumb: String?) : super() {
        this.itemImageId = itemImageId
        this.imagePath = imagePath
        this.thumb = thumb
    }

    protected constructor(`in`: Parcel) {
        itemImageId = `in`.readInt()
        imagePath = `in`.readString()
        thumb = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(itemImageId)
        dest.writeString(imagePath)
        dest.writeString(thumb)
    }

    override fun toString(): String {
        return "ItemImage{" +
                "ItemImageId=" + itemImageId +
                ", ImagePath='" + imagePath + '\'' +
                ", Thumb='" + thumb + '\'' +
                '}'
    }

    companion object CREATOR : Parcelable.Creator<ItemPosition> {
        override fun createFromParcel(parcel: Parcel): ItemPosition {
            return ItemPosition(parcel)
        }

        override fun newArray(size: Int): Array<ItemPosition?> {
            return arrayOfNulls(size)
        }
    }
}
