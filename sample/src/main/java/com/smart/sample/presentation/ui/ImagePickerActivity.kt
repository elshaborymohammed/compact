package com.smart.sample.presentation.ui

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.checkSelfPermission
import com.compact.app.extensions.base64
import com.compact.app.extensions.setImageBase64
import com.compact.picker.ImagePicker
import com.smart.sample.R
import kotlinx.android.synthetic.main.activity_image_picker.*

class ImagePickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_picker)
        action_image.setOnClickListener {
            if (checkSelfPermission(this, ImagePicker.PERMISSIONS[0]) != PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, ImagePicker.PERMISSIONS, ImagePicker.REQUEST_CODE)
            } else {
                ImagePicker.build(this)
            }
        }

        action_image_backup.setOnClickListener {
            action_image.base64()?.apply {
                action_image_backup.setImageBase64(this)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            ImagePicker.REQUEST_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PERMISSION_GRANTED) {
                    ImagePicker.build(this)
                }
                return
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ImagePicker.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            try {
                data?.apply { ImagePicker.setImage(action_image, data) }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}
