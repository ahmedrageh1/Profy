package com.rageh.profy.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.fragment.app.Fragment


const val REQUEST_CODE_CAPTURE_IMAGE = 100
const val REQUEST_CODE_PICK_IMAGE = 200

class ImageUtils {

    companion object {
        @JvmStatic
        fun createPickImageIntent(allowMultiple: Boolean) =
            Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
                putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple)
            }

        @JvmStatic
        fun createCaptureImageIntent(photoUri: Uri) =
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            }
    }

}

private fun resolveCaptureImageResult(requestCode: Int, resultCode: Int, data: Intent?) =
    requestCode == REQUEST_CODE_CAPTURE_IMAGE && resultCode == Activity.RESULT_OK

private fun resolvePickImageResult(requestCode: Int, resultCode: Int, data: Intent?): List<Uri> {
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

fun Activity.dispatchCaptureImageIntent(intent: Intent) =
    intent.resolveActivity(packageManager)?.let {
        startActivityForResult(intent, REQUEST_CODE_CAPTURE_IMAGE)
    }

fun Fragment.dispatchCaptureImageIntent(intent: Intent) =
    intent.resolveActivity(requireContext().packageManager)?.let {
        startActivityForResult(intent, REQUEST_CODE_CAPTURE_IMAGE)
    }

fun Activity.dispatchPickImageIntent(intent: Intent) =
    intent.resolveActivity(packageManager)?.let {
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
    }

fun Fragment.dispatchPickImageIntent(intent: Intent) =
    intent.resolveActivity(requireContext().packageManager)?.let {
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
    }

fun Activity.resolveCaptureImageResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean =
    resolveCaptureImageResult(requestCode, resultCode, data)

fun Fragment.resolveCaptureImageResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean =
    resolveCaptureImageResult(requestCode, resultCode, data)

fun Activity.resolvePickImageResult(requestCode: Int, resultCode: Int, data: Intent?): List<Uri> =
    resolvePickImageResult(requestCode, resultCode, data)

fun Fragment.resolvePickImageResult(requestCode: Int, resultCode: Int, data: Intent?): List<Uri> =
    resolvePickImageResult(requestCode, resultCode, data)