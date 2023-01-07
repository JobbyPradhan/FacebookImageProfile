package com.mhs.facebookimageprofile.model

import android.os.Parcel
import android.os.Parcelable.Creator
import com.mhs.facebookimageprofile.Assymetric.AsymmetricItem

open class ItemPosition : AsymmetricItem {
    private var columnSpan = 0
    private var rowSpan = 0f
    private var position = 0



    @JvmOverloads
    constructor(columnSpan: Int = 1, rowSpan: Float = 1f, position: Int = 0) {
        this.columnSpan = columnSpan
        this.rowSpan = rowSpan
        this.position = position
    }

    constructor(`in`: Parcel) {
        readFromParcel(`in`)
    }

    override fun getColumnSpan(): Int {
        return columnSpan
    }

    override fun getRowSpan(): Float {
        return rowSpan
    }

    open fun setColumnSpan(columnSpan: Int) {
        this.columnSpan = columnSpan
    }

    open fun setPosition(position: Int) {
        this.position = position
    }

    open fun setRowSpan(rowSpan: Float) {
        this.rowSpan = rowSpan
    }


    override fun toString(): String {
        return String.format("%s: %sx%s", position, rowSpan, columnSpan)
    }

    override fun describeContents(): Int {
        return 0
    }

    private fun readFromParcel(`in`: Parcel) {
        columnSpan = `in`.readInt()
        rowSpan = `in`.readFloat()
        position = `in`.readInt()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(columnSpan)
        dest.writeFloat(rowSpan)
        dest.writeInt(position)
    }

    companion object CREATOR : Creator<ItemPosition> {
        override fun createFromParcel(parcel: Parcel): ItemPosition {
            return ItemPosition(parcel)
        }

        override fun newArray(size: Int): Array<ItemPosition?> {
            return arrayOfNulls(size)
        }
    }
}
