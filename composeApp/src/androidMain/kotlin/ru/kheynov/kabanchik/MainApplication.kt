package ru.kheynov.kabanchik

import android.app.Application
import com.yandex.authsdk.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import ru.kheynov.kabanchik.di.appModule
import ru.kheynov.kabanchik.utils.logger.KLogger
import ru.kheynov.kabanchik.utils.logger.koinKLogger

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            koinKLogger()
            androidContext(this@MainApplication)
            modules(appModule)
        }

        KLogger.isLoggingEnabled = BuildConfig.DEBUG
    }
}