package org.alexcawl.forecaster.feature.settings.ui.adapter

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    @DimenRes private val margin: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) = with(outRect) {
        val marginSize = parent.context.resources.getDimensionPixelSize(margin)
        if (parent.getChildAdapterPosition(view) == 0) {
            top = marginSize
        }
        left = marginSize
        right = marginSize
        bottom = marginSize
    }
}
