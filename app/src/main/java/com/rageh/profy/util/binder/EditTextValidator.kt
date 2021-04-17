package com.rageh.profy.util.binder

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

class EditTextValidator {
    companion object {

        const val TYPE_NAME = 1
        const val TYPE_FULL_NAME = 2
        const val TYPE_PHONE = 3
        const val TYPE_EMAIL = 4
        const val TYPE_PASSWORD = 5

        private const val VALIDATION_PATTERN_NAME = "\\w+"
        private const val VALIDATION_PATTERN_FULL_NAME = "\\w+(\\s\\w+)*"
        private const val VALIDATION_PATTERN_PHONE = "\\d{6,12}"
        private const val VALIDATION_PATTERN_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"
        private const val VALIDATION_PATTERN_PASSWORD = "\\w{8,}" //dummy (unused)

        @JvmStatic
        @BindingAdapter("editTextValidationType", "editTextValidationErrorMessage")
        fun setValidationType(editText: EditText, validationType: Int, errorMessage: String) {
            val typePattern = when (validationType) {
                TYPE_NAME -> VALIDATION_PATTERN_NAME
                TYPE_FULL_NAME -> VALIDATION_PATTERN_FULL_NAME
                TYPE_PHONE -> VALIDATION_PATTERN_PHONE
                TYPE_EMAIL -> VALIDATION_PATTERN_EMAIL
                TYPE_PASSWORD -> VALIDATION_PATTERN_PASSWORD
                else -> null
            }

            typePattern?.let { pattern ->
                editText.doAfterTextChanged { text ->
                    text?.let {
                        if (!it.matches(pattern.toRegex())) {
                            editText.error = errorMessage
                        } else {
                            editText.error = null
                        }
                    }

                }
            }

        }

        @JvmStatic
        @BindingAdapter("editTextValidationType", "editTextValidationErrorMessage")
        fun setValidationType(inputLayout: TextInputLayout, validationType: Int, errorMessage: String) {
            val typePattern = when (validationType) {
                TYPE_NAME -> VALIDATION_PATTERN_NAME
                TYPE_FULL_NAME -> VALIDATION_PATTERN_FULL_NAME
                TYPE_PHONE -> VALIDATION_PATTERN_PHONE
                TYPE_EMAIL -> VALIDATION_PATTERN_EMAIL
                TYPE_PASSWORD -> VALIDATION_PATTERN_PASSWORD
                else -> null
            }

            typePattern?.let { pattern ->
                inputLayout.editText?.doAfterTextChanged { text ->
                    text?.let {
                        if (!it.matches(pattern.toRegex())) {
                            inputLayout.isErrorEnabled = true
                            inputLayout.error = errorMessage
                        } else {
                            inputLayout.isErrorEnabled = false
                            inputLayout.error = null

                        }
                    }

                }
            }

        }
    }

}