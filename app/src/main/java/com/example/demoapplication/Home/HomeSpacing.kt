package com.example.demoapplication.Home

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class HomeSpacing(private val spacing: Int) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        when(parent.getChildAdapterPosition(view)) {
            0,2,4 -> {
                outRect.top = spacing
                outRect.left = spacing
                outRect.right = spacing
            }
            1,3,5 -> {
                outRect.top = spacing
                outRect.right = spacing
            }
            6 -> {
                outRect.top = spacing
                outRect.left = spacing
                outRect.right = spacing
                outRect.bottom = spacing
            }
            else -> {
                outRect.top = spacing
                outRect.right = spacing
                outRect.bottom = spacing
            }
        }
    }
}