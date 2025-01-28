package ru.kheynov.kabanchik.utils.logger

import android.util.Log

actual object KLogger {
    var isLoggingEnabled = false

    actual fun i(tag: String, message: String) {
        if (!isLoggingEnabled) return
        Log.i(tag, message)
    }

    actual fun d(tag: String, message: String) {
        if (!isLoggingEnabled) return
        Log.d(tag, message)
    }

    actual fun e(tag: String, message: String, throwable: Throwable?) {
        if (!isLoggingEnabled) return
        Log.e(tag, message, throwable)
    }

    actual fun w(tag: String, message: String) {
        if (!isLoggingEnabled) return
        Log.w(tag, message)
    }
}