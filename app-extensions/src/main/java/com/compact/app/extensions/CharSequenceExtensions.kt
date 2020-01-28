package com.compact.app.extensions

import android.util.Patterns

/**
 * CharSequence Extensions.
 * @author Mohammed Elshabory
 */

fun CharSequence.isPassword(): Boolean {
    return matches(Regex("^.{8,}\$"))
}

fun CharSequence.limit(min: Int, max: Int): Boolean {
    return matches(Regex("^.{$min,$max}\$"))
}

fun CharSequence.isEmail(): Boolean {
    return matches(Patterns.EMAIL_ADDRESS.toRegex())
}

fun CharSequence.isPhone(): Boolean {
    return matches(Patterns.PHONE.toRegex())
}

fun CharSequence.isDigits(): Boolean {
    return matches(Regex("^[0-9]*\$"))
}

fun CharSequence.isUserName(): Boolean {
    return matches(Regex("^[a-z0-9_-]{3,15}\$"))
}

fun CharSequence.isNotNullOrEmpty(): Boolean {
    return !isNullOrEmpty()
}