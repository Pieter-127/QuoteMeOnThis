package com.pieterventer.quotemeonthis

import android.app.Application

import com.pieterventer.quotemeonthis.di.apiModule
import com.pieterventer.quotemeonthis.di.repositoryModule
import com.pieterventer.quotemeonthis.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class QuoteApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@QuoteApplication)
            modules(listOf(viewModelModule, apiModule, repositoryModule))
        }
    }
}