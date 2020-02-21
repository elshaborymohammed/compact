package com.compact.app.extensions

import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout
import com.jakewharton.rxbinding3.view.focusChanges
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

fun TextInputLayout.text(): String {
    return if (this.editText != null) this.editText!!.editableText.toString() else ""
}

fun TextInputLayout.text(text: String) {
    this.editText?.setText(text)
}

fun TextInputLayout.text(@StringRes res: Int) {
    this.editText?.setText(res)
}

fun TextInputLayout.noError() {
    error = null
}

fun TextInputLayout.error(@StringRes res: Int, boolean: Boolean = true) {
    isErrorEnabled = true
    error = if (!boolean) null else resources.getString(res)
}

private fun <T> beforeMap(): ObservableTransformer<T, T> = ObservableTransformer {
    it.debounce(800, TimeUnit.MILLISECONDS)
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .skip(2)
}

private fun afterMap(): ObservableTransformer<Boolean, Boolean> {
    return ObservableTransformer {
        it.distinctUntilChanged().doOnError(Throwable::printStackTrace)
    }
}

private fun afterMap(inputLayout: TextInputLayout, @StringRes res: Int): ObservableTransformer<Boolean, Boolean> {
    return ObservableTransformer {
        it.doOnNext { error -> inputLayout.error(res, !error) }
                .doOnError(Throwable::printStackTrace)
    }
}

private fun checkText(inputLayout: TextInputLayout, text: CharSequence,
                      boolean: Boolean,
                      @StringRes required: Int,
                      @StringRes invalid: Int): Boolean {
    return when {
        text.contains("no") -> {
            inputLayout.error(required)
            false
        }
        boolean -> {
            inputLayout.noError()
            true
        }
        else -> {
            inputLayout.error(invalid)
            false
        }
    }
}

private fun predictor() = BiFunction { text: CharSequence, focus: Boolean ->
    if (focus) {
        return@BiFunction text
    } else {
        if (text.isEmpty()) {
            return@BiFunction "no"
        } else {
            return@BiFunction text
        }
    }
}

/***
 * login validation
 * */
fun TextInputLayout.login(@StringRes required: Int = R.string.field_required,
                          @StringRes invalid: Int = R.string.invalid_login): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(), focusChanges(), predictor())
                .compose(beforeMap())
                .map { checkText(this@login, it, it.isPhone() || it.isEmail(), required, invalid) }
                .compose(afterMap())

    }
}

/***
 * user name validation
 * */
fun TextInputLayout.username(@StringRes required: Int = R.string.field_required,
                             @StringRes invalid: Int = R.string.invalid_username): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(), focusChanges(), predictor())
                .compose(beforeMap())
                .map { checkText(this@username, it, it.isUserName(), required, invalid) }
                .compose(afterMap())
    }
}

/***
 * full name validation
 * */
fun TextInputLayout.fullName(@StringRes required: Int = R.string.field_required,
                             @StringRes invalid: Int = R.string.invalid_full_name): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(), focusChanges(), predictor())
                .compose(beforeMap())
                .map { checkText(this@fullName, it, it.isFullName(), required, invalid) }
                .compose(afterMap())
    }
}

/***
 * phone validation
 * */
fun TextInputLayout.phone(@StringRes required: Int = R.string.field_required,
                          @StringRes invalid: Int = R.string.invalid_phone): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(), focusChanges(), predictor())
                .compose(beforeMap())
                .map { checkText(this@phone, it, it.isPhone(), required, invalid) }
                .compose(afterMap())
    }
}

/***
 * email validation
 * */
fun TextInputLayout.email(@StringRes required: Int = R.string.field_required,
                          @StringRes invalid: Int = R.string.invalid_email): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(), focusChanges(), predictor())
                .compose(beforeMap())
                .map { checkText(this@email, it, it.isEmail(), required, invalid) }
                .compose(afterMap())
    }
}

/***
 * password validation
 * */
fun TextInputLayout.password(@StringRes required: Int = R.string.field_required,
                             @StringRes invalid: Int = R.string.invalid_password): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(), focusChanges(), predictor())
                .compose(beforeMap())
                .map { checkText(this@password, it, it.isPassword(), required, invalid) }
                .compose(afterMap())
    }
}

/***
 * confirm password validation
 * */
fun TextInputLayout.confirmPassword(password: TextInputLayout, @StringRes invalid: Int = R.string.invalid_password_confirmation): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(),
                password.editText!!.textChanges(),
                BiFunction { confirm: CharSequence, password: CharSequence ->
                    confirm.isPassword() && password.isPassword() &&
                            confirm.toString().compareTo(password.toString()) == 0
                })
                .debounce(800, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .skip(1)
                .distinctUntilChanged()
                .compose(afterMap(this@confirmPassword, invalid))
    }
}

/***
 * not null or empty validation
 * */
fun TextInputLayout.notNullOrEmpty(@StringRes required: Int = R.string.field_required,
                                   @StringRes invalid: Int = R.string.field_required): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(), focusChanges(), predictor())
                .compose(beforeMap())
                .map { checkText(this@notNullOrEmpty, it, it.isNotNullOrEmpty(), required, invalid) }
                .compose(afterMap())
    }
}

/***
 * digits validation
 * */
fun TextInputLayout.digits(@StringRes required: Int = R.string.field_required,
                           @StringRes invalid: Int = R.string.invalid_digits): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(), focusChanges(), predictor())
                .compose(beforeMap())
                .map { checkText(this@digits, it, it.isDigits(), required, invalid) }
                .compose(afterMap())
    }
}

/***
 * custom Regex validation
 * */
fun TextInputLayout.matches(regex: Regex, @StringRes invalid: Int): Observable<Boolean> {
    editText!!.apply {
        return textChanges().compose(beforeMap())
                .map { it.matches(regex) }
                .compose(afterMap(this@matches, invalid))
    }
}

fun TextInputLayout.matchesAndRequired(regex: Regex,
                                       @StringRes invalid: Int,
                                       @StringRes required: Int = R.string.field_required): Observable<Boolean> {
    editText!!.apply {
        return Observable.combineLatest(textChanges(), focusChanges(), predictor())
                .compose(beforeMap())
                .map { checkText(this@matchesAndRequired, it, it.matches(regex), required, invalid) }
                .compose(afterMap())
    }
}