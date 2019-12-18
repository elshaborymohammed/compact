package com.compact.app.extensions

import android.widget.EditText
import androidx.annotation.StringRes
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * EditText Extensions.
 * @author Mohammed Elshabory
 */

fun EditText.isLoginName(): Boolean {
    return editableText.isLoginName()
}

fun EditText.isPassword(): Boolean {
    return editableText.isPassword()
}

fun EditText.isEmail(): Boolean {
    return editableText.isEmail()
}

fun EditText.isPhone(): Boolean {
    return editableText.isPhone()
}

fun EditText.isNotNullOrEmpty(): Boolean {
    return editableText.isNotNullOrEmpty()
}

fun EditText.phone(@StringRes res: Int) {
    editableText.apply {
        textChanges()
            .skipInitialValue()
            .debounce(800, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ error(it.isPhone(), res) }, Throwable::printStackTrace)
    }
}

fun EditText.email(@StringRes res: Int) {
    editableText.apply {
        textChanges()
            .skipInitialValue()
            .debounce(800, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ error(it.isEmail(), res) }, Throwable::printStackTrace)
    }
}

fun EditText.password(@StringRes res: Int) {
    editableText.apply {
        textChanges()
            .skipInitialValue()
            .debounce(800, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ error(it.isPassword(), res) }, Throwable::printStackTrace)
    }
}

fun EditText.notNullOrEmpty(@StringRes res: Int) {
    editableText.apply {
        textChanges()
            .skipInitialValue()
            .debounce(800, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ error(it.isNotNullOrEmpty(), res) }, Throwable::printStackTrace)
    }
}

fun EditText.error(boolean: Boolean, @StringRes res: Int) {
    error = when {
        boolean -> {
            resources.getString(res)
        }
        else -> {
            null
        }
    }
}