package com.overcoffeesolutions.badawar.helper

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream


object ImageHelper {

    fun encodeBitmap(bm: Bitmap): String {
        val baos = ByteArrayOutputStream()
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos) //bm is the bitmap object
        val b = baos.toByteArray()

        return Base64.encodeToString(b, Base64.DEFAULT)
    }

    fun decodeBase64(input: String): Bitmap {
        val decodedBytes = Base64.decode(input, 0)
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }
}