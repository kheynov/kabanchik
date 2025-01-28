package ru.kheynov.kabanchik.utils.logger

actual object KLogger {
    actual fun i(tag: String, message: String) =
        println(mergeLogMessage(tag, message))

    actual fun d(tag: String, message: String) =
        println(mergeLogMessage(tag, message))

    actual fun e(tag: String, message: String, throwable: Throwable?) =
        println(mergeLogMessage(tag, message, throwable))

    actual fun w(tag: String, message: String) =
        println(mergeLogMessage(tag, message))
}

private fun mergeLogMessage(tag: String, message: String, th: Throwable? = null) =
    "$tag:  $message\n${th?.stackTrace}"