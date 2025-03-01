package com.fintrack.di

import com.fintrack.common.Dispatcher
import com.fintrack.common.FTDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

/**
 * Created by fasil on 28/02/25.
 */
fun providesCoroutineScope(
    @Dispatcher(FTDispatcher.Default) dispatcher: CoroutineDispatcher,
): CoroutineScope = CoroutineScope(SupervisorJob() + dispatcher)

val coroutineScopeModule = module {
    single { providesCoroutineScope(get()) }
}