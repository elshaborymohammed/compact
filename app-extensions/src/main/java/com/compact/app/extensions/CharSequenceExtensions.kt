package com.compact.app.extensions

import android.util.Patterns

/**
 * CharSequence Extensions.
 * @author Mohammed Elshabory
 */

fun CharSequence.isLoginName(): Boolean {
    return matches(Regex("(?:[a-z0-9!#$%'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
}

fun CharSequence.isPassword(): Boolean {
    return matches(Regex("^.{8,}\$"))
}

fun CharSequence.limit(count: Int): Boolean {
    return matches(Regex("^.{$count,}\$"))
}

fun CharSequence.isEmail(): Boolean {
    return matches(Patterns.EMAIL_ADDRESS.toRegex())
}

fun CharSequence.isPhone(): Boolean {
    return matches(Patterns.PHONE.toRegex())
}

fun CharSequence.isNotNullOrEmpty(): Boolean {
    return ! isNullOrEmpty()
}