package com.compact.app.extensions

import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * TextInputLayout Extensions.
 * @author Mohammed Elshabory
 */

fun TextInputLayout.loginName(@StringRes res: Int): Observable<Boolean>? {
    editText !!.apply {
        return textChanges()
            .compose(beforeMap())
            .map { it.isEmail() || it.isPhone() }
            .compose(afterMap(this@loginName, res))
    }
}

fun TextInputLayout.loginName(): Observable<Boolean>? {
    return loginName(R.string.invalid_email_or_mobile)
}

fun TextInputLayout.phone(@StringRes res: Int): Observable<Boolean>? {
    editText !!.apply {
        return textChanges()
            .compose(beforeMap())
            .map { it.isPhone() }
            .compose(afterMap(this@phone, res))
    }
}

fun TextInputLayout.phone(): Observable<Boolean>? {
    return phone(R.string.invalid_mobile_number)
}

fun TextInputLayout.email(@StringRes res: Int): Observable<Boolean>? {
    editText !!.apply {
        return textChanges()
            .compose(beforeMap())
            .map { it.isEmail() }
            .compose(afterMap(this@email, res))
    }
}

fun TextInputLayout.email(): Observable<Boolean>? {
    return email(R.string.invalid_email)
}

fun TextInputLayout.password(@StringRes res: Int): Observable<Boolean> {
    editText !!.apply {
        return textChanges()
            .compose(beforeMap())
            .map { it.isPassword() }
            .compose(afterMap(this@password, res))
    }
}

fun TextInputLayout.confirmPassword(password: TextInputLayout): Observable<Boolean>? {
    println("password = [${password}]")
    return confirmPassword(R.string.password_does_not_match, password)
}

fun TextInputLayout.confirmPassword(@StringRes res: Int, password: TextInputLayout): Observable<Boolean> {
    editText !!.apply {
        return Observable.combineLatest(textChanges(),
            password.editText !!.textChanges(),
            BiFunction { confirm: CharSequence, password: CharSequence ->
                confirm.isPassword() && password.isPassword() &&
                        confirm.toString().compareTo(password.toString()) == 0
            })
            .compose(beforeMap())
            .distinctUntilChanged()
            .compose(afterMap(this@confirmPassword, res))
    }
}

fun TextInputLayout.password(): Observable<Boolean>? {
    return password(R.string.password_too_short)
}

fun TextInputLayout.notNullOrEmpty(@StringRes res: Int): Observable<Boolean> {
    editText !!.apply {
        return textChanges()
            .compose(beforeMap())
            .map { it.isNotNullOrEmpty() }
            .compose(afterMap(this@notNullOrEmpty, res))
    }
}

fun TextInputLayout.notNullOrEmpty(): Observable<Boolean>? {
    return notNullOrEmpty(R.string.field_required)
}

fun TextInputLayout.error(boolean: Boolean, @StringRes res: Int) {
    error = resources.getString(res)
    isErrorEnabled = ! boolean
}

fun <T> beforeMap(): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.debounce(800, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .skip(1)
    }
}

fun afterMap(inputLayout: TextInputLayout, @StringRes res: Int): ObservableTransformer<Boolean, Boolean> {
    return ObservableTransformer { it ->
        it.doOnNext { inputLayout.error(it, res) }
            .doOnError(Throwable::printStackTrace)
    }
}

fun TextInputLayout.text(): CharSequence {
    return if (this.editText != null) this.editText !!.editableText.toString() else ""
}