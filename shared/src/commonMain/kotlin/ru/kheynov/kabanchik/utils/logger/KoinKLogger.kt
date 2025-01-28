package ru.kheynov.kabanchik.utils.logger

import org.koin.core.KoinApplication
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.logger.KOIN_TAG
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE


class KoinKLogger(level: Level = Level.INFO) : Logger(level) {
    override fun display(level: Level, msg: MESSAGE) {
        when (level) {
            Level.DEBUG -> KLogger.d(KOIN_TAG, msg)
            Level.INFO -> KLogger.i(KOIN_TAG, msg)
            Level.WARNING -> KLogger.w(KOIN_TAG, msg)
            Level.ERROR -> KLogger.e(KOIN_TAG, msg)
            else -> KLogger.e(KOIN_TAG, msg)
        }
    }
}

@OptIn(KoinInternalApi::class)
fun KoinApplication.koinKLogger(level: Level = Level.INFO): KoinApplication = this.apply {
    koin.setupLogger(KoinKLogger(level))
}