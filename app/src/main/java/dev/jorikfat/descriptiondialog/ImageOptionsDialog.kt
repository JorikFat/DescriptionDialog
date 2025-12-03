package dev.jorikfat.descriptiondialog

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import com.google.android.material.bottomsheet.BottomSheetDialog
import dev.jorikfat.descriptiondialog.databinding.DialogOptionsBinding

class ImageOptionsDialog(
    context: Context,
    @DrawableRes imageId : Int,
    share: () -> Unit,
    copy: () -> Unit,
    delete: () -> Unit,
) : BottomSheetDialog(context) {

    private val binding = DialogOptionsBinding.inflate(LayoutInflater.from(context))

    init {
        setContentView(binding.root)
        binding.image.setImageResource(imageId)
        binding.remove.setOnClickListener {
            delete()
            close()
        }
        binding.copy.setOnClickListener {
            copy()
            close()
        }
        binding.share.setOnClickListener {
            share()
            close()
        }
    }

    private fun close() {
        dismiss()
    }
}