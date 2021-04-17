package com.rageh.profy.util.binder

import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.rageh.profy.data.entity.skeleton.IdentifiedItem

class SpinnerDataBinders {

    companion object {

        @JvmStatic
        @BindingAdapter("selectionItemId")
        fun setSelectionItemId(view: Spinner, itemId: Long) {
            view.adapter?.let {
                if (it.count > 0)
                    for (i in 0..it.count) {
                        it.getItem(i).let { item ->
                            when (item) {
                                is IdentifiedItem -> {
                                    if (itemId == item.getIdentifier()) {
                                        view.setSelection(i, true)
                                        return
                                    }
                                }
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
                        is IdentifiedItem -> item.getIdentifier() as Long
                        else -> 0L
                    }
                }
            }
            return 0
        }
    }
}