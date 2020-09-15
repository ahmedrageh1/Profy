package com.rageh.profy.util

import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.rageh.profy.data.entity.AudioProfile

object CustomDataBinders {

    @JvmStatic
    @BindingAdapter("selectionItemId")
    fun setSelectionItemId(view: Spinner, itemId: Long) {
        view.adapter?.let {
            for (i in 0..it.count) {
                it.getItem(i).let { item ->
                    when (item) {
                        is AudioProfile -> {
                            if (itemId == item.id) {
                                view.setSelection(i, true)
                                return
                            }
                        }
                        //TODO add other used types
                    }
                }
            }
        }

    }

    @JvmStatic
    @InverseBindingAdapter(
        attribute = "selectionItemId",
        event = "android:selectedItemPositionAttrChanged"
    )
    fun getSelectionItemId(view: Spinner): Long {
        view.adapter?.let {
            it.getItem(view.selectedItemPosition).let { item ->
                return when (item) {
                    is AudioProfile -> item.id
                    else -> 0L
                }
                //TODO add other used types
            }
        }
        return 0
    }
}