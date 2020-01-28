package com.compact.app.extensions

import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

/**
 * TextInputLayout Extensions.
 * @author Mohammed Elshabory
 */

fun TextInputLayout.text(): CharSequence {
    return if (this.editText != null) this.editText!!.editableText.toString() else ""
}

fun TextInputLayout.error(boolean: Boolean, @StringRes res: Int) {
    isErrorEnabled = true
    error = if (boolean) null else resources.getString(res)
}

private fun <T> beforeMap(): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.debounce(800, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .skip(1)
    }
}

private fun afterMap(inputLayout: TextInputLayout, @StringRes res: Int): ObservableTransformer<Boolean, Boolean> {
    return ObservableTransformer { it ->
        it.doOnNext { inputLayout.error(it, res) }
                .doOnError(Throwable::printStackTrace)
    }
}

/***
 * user name validation
 * */
fun TextInputLayout.loginName(@StringRes res: Int): Observable<Boolean> {
    editText!!.apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isEmail() || it.isPhone() }
                .compose(afterMap(this@loginName, res))
    }
}

fun TextInputLayout.loginName(): Observable<Boolean> {
    return loginName(R.string.invalid_email_or_mobile)
}

/***
 * user name validation
 * */
fun TextInputLayout.userName(@StringRes res: Int): Observable<Boolean> {
    editText!!.apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isUserName() }
                .compose(afterMap(this@userName, res))
    }
}

fun TextInputLayout.userName(): Observable<Boolean> {
    return userName(R.string.invalid_username)
}

/***
 * phone validation
 * */
fun TextInputLayout.phone(@StringRes res: Int): Observable<Boolean> {
    editText!!.apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isPhone() }
                .compose(afterMap(this@phone, res))
    }
}

fun TextInputLayout.phone(): Observable<Boolean> {
    return phone(R.string.invalid_mobile_number)
}

/***
 * email validation
 * */
fun TextInputLayout.email(@StringRes res: Int): Observable<Boolean> {
    editText!!.apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isEmail() }
                .compose(afterMap(this@email, res))
    }
}

fun TextInputLayout.email(): Observable<Boolean> {
    return email(R.string.invalid_email)
}

/***
 * password validation
 * */
fun TextInputLayout.password(@StringRes res: Int): Observable<Boolean> {
    editText!!.apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isPassword() }
                .compose(afterMap(this@password, res))
    }
}

fun TextInputLayout.password(): Observable<Boolean> {
    return password(R.string.password_too_short)
}

/***
 * confirm password validation
 * */
fun TextInputLayout.confirmPassword(@StringRes res: Int, password: TextInputLayout): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(),
                password.editText!!.textChanges(),
                BiFunction { confirm: CharSequence, password: CharSequence ->
                    confirm.isPassword() && password.isPassword() &&
                            confirm.toString().compareTo(password.toString()) == 0
                })
                .compose(beforeMap())
                .distinctUntilChanged()
                .compose(afterMap(this@confirmPassword, res))
    }
}

fun TextInputLayout.confirmPassword(password: TextInputLayout): Observable<Boolean> {
    return confirmPassword(R.string.password_does_not_match, password)
}

/***
 * not null or empty validation
 * */
fun TextInputLayout.notNullOrEmpty(@StringRes res: Int): Observable<Boolean> {
    editText!!.apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isNotNullOrEmpty() }
                .compose(afterMap(this@notNullOrEmpty, res))
    }
}

fun TextInputLayout.notNullOrEmpty(): Observable<Boolean> {
    return notNullOrEmpty(R.string.field_required)
}

/***
 * digits validation
 * */
fun TextInputLayout.digits(@StringRes res: Int): Observable<Boolean> {
    editText!!.apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isDigits() }
                .compose(afterMap(this@digits, res))
    }
}

fun TextInputLayout.digits(): Observable<Boolean> {
    return digits(R.string.invalid_digits)
}