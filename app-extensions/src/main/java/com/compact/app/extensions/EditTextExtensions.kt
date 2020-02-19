package com.compact.app.extensions

import android.widget.EditText
import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

/**
 * EditText Extensions.
 * @author Mohammed Elshabory
 */

fun EditText.error(boolean: Boolean, @StringRes res: Int) {
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

private fun afterMap(editText: EditText, @StringRes res: Int): ObservableTransformer<Boolean, Boolean> {
    return ObservableTransformer { it ->
        it.doOnNext { editText.error(it, res) }
                .doOnError(Throwable::printStackTrace)
    }
}

/***
 * user name validation
 * */
fun EditText.loginName(@StringRes res: Int): Observable<Boolean> {
    apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isEmail() || it.isPhone() }
                .compose(afterMap(this@loginName, res))
    }
}

fun EditText.loginName(): Observable<Boolean> {
    return loginName(R.string.invalid_login_name)
}

/***
 * user name validation
 * */
fun EditText.userName(@StringRes res: Int): Observable<Boolean> {
    apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isUserName() }
                .compose(afterMap(this@userName, res))
    }
}

fun EditText.userName(): Observable<Boolean> {
    return userName(R.string.invalid_username)
}

/***
 * phone validation
 * */
fun EditText.phone(@StringRes res: Int): Observable<Boolean> {
    apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isPhone() }
                .compose(afterMap(this@phone, res))
    }
}

fun EditText.phone(): Observable<Boolean> {
    return phone(R.string.invalid_mobile_number)
}

/***
 * email validation
 * */
fun EditText.email(@StringRes res: Int): Observable<Boolean> {
    apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isEmail() }
                .compose(afterMap(this@email, res))
    }
}

fun EditText.email(): Observable<Boolean> {
    return email(R.string.invalid_email)
}

/***
 * password validation
 * */
fun EditText.password(@StringRes res: Int): Observable<Boolean> {
    apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isPassword() }
                .compose(afterMap(this@password, res))
    }
}

fun EditText.password(): Observable<Boolean> {
    return password(R.string.password_too_short)
}

/***
 * confirm password validation
 * */
fun EditText.confirmPassword(@StringRes res: Int, password: TextInputLayout): Observable<Boolean> {
    apply {
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

fun EditText.confirmPassword(password: TextInputLayout): Observable<Boolean> {
    return confirmPassword(R.string.password_does_not_match, password)
}

/***
 * not null or empty validation
 * */
fun EditText.notNullOrEmpty(@StringRes res: Int): Observable<Boolean> {
    apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isNotNullOrEmpty() }
                .compose(afterMap(this@notNullOrEmpty, res))
    }
}

fun EditText.notNullOrEmpty(): Observable<Boolean> {
    return notNullOrEmpty(R.string.field_required)
}

/***
 * digits validation
 * */
fun EditText.digits(@StringRes res: Int): Observable<Boolean> {
    apply {
        return textChanges()
                .compose(beforeMap())
                .map { it.isDigits() }
                .compose(afterMap(this@digits, res))
    }
}

fun EditText.digits(): Observable<Boolean> {
    return digits(R.string.invalid_digits)
}