package com.rageh.profy.util.binder

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

class RecyclerBinders {
    companion object {

        @JvmStatic
        @BindingAdapter("adapter")
        fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
            recyclerView.adapter = adapter
        }

        @JvmStatic
        @BindingAdapter("hasFixedSize")
        fun setHasFixedSize(recyclerView: RecyclerView, hasFixedSize: Boolean) {
            recyclerView.setHasFixedSize(hasFixedSize)
        }

    }

}