package es.animaldevs.app

import android.app.Application
import es.animaldevs.app.injection.Injector
import timber.log.Timber
import timber.log.Timber.DebugTree


class App : Application() {
    init {
        Injector.init(this)
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}