package com.fintrack.di

import android.app.Application
import android.content.res.Resources
import com.fintrack.data.local.db.AppDatabase
import org.koin.dsl.module

/**
 * Created by fasil on 28/02/25.
 */

fun provideResources(application: Application): Resources = application.resources


val appModule = module {
    single<AppDatabase> { AppDatabase.getInstance(get()) }
    single { provideResources(get()) }
}
