package com.mhs.facebookimageprofile.util

import android.graphics.Rect
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class SpacesItemDecoration(
    private val space: Int
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = space
    }

}

fun EditText.onActionDone(_onActionDone: (Int) -> Boolean) {
    setOnEditorActionListener(object : IEditTxtActionListener {
        override fun onActionDone(actionId: Int) {
            _onActionDone.invoke(actionId)
        }
    })
}

interface IEditTxtActionListener: TextView.OnEditorActionListener{
    override fun onEditorAction(p0: TextView?, actionId: Int, p2: KeyEvent?): Boolean {
        onActionDone(actionId)
        return false
    }
    fun onActionDone(actionId:Int)
}