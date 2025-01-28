package ru.kheynov.kabanchik.utils.logger

expect object KLogger {
    fun i(tag: String, message: String)
    fun d(tag: String, message: String)
    fun e(tag: String, message: String, throwable: Throwable? = null)
    fun w(tag: String, message: String)
}