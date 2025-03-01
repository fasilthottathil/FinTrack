package com.fintrack.common


/**
 * Created by fasil on 28/02/25.
 */
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: FTDispatcher)

enum class FTDispatcher {
    IO,
    Default
}