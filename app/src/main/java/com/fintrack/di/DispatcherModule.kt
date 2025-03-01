package com.fintrack.di

import com.fintrack.common.Dispatcher
import com.fintrack.common.FTDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

/**
 * Created by fasil on 01/03/25.
 */
@Dispatcher(FTDispatcher.IO)
fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

@Dispatcher(FTDispatcher.Default)
fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

val dispatcherModule = module {
    single { providesIODispatcher() }
    single { providesDefaultDispatcher() }
}