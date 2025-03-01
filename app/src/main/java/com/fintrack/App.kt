package com.fintrack

import android.app.Application
import com.fintrack.di.appModule
import com.fintrack.di.coroutineScopeModule
import com.fintrack.di.dispatcherModule
import com.fintrack.di.repositoryModule
import com.fintrack.di.useCaseModule
import com.fintrack.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

/**
 * Created by fasil on 28/02/25.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                appModule,
                dispatcherModule,
                coroutineScopeModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}