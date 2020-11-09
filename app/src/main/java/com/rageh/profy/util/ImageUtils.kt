package com.rageh.profy.util

import android.app.Activity
import android.content.Intent
import android.net.Uri

const val REQUEST_CODE_PICK_IMAGE = 200

class ImageUtils {

    companion object {
        @JvmStatic
        fun createPickImageIntent(allowMultiple: Boolean) =
            Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
                putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple)
            }
    }

}

fun Activity.dispatchPickImageIntent(intent: Intent) {
    startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
}

fun Activity.resolvePickImageResult(requestCode: Int, resultCode: Int, data: Intent?): List<Uri> {
    if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == Activity.RESULT_OK) {
        data?.data?.let {
            return listOf(it)
        }
        data?.clipData?.let {
            val uriList = mutableListOf<Uri>()
            for (position in 0 until it.itemCount) {
                uriList.add(it.getItemAt(position).uri)
            }
            return uriList
        }
    }
    return emptyList()
}