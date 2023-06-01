package com.example.sportquiz.utils

import kotlinx.coroutines.flow.MutableSharedFlow

class Event<T>(
    value: T
) {

    private var _value: T? = value

    fun get(): T? = _value.also { _value = null }

}

suspend fun <T> MutableSharedFlow<T>.publishEvent(value: T) {
    this.emit(value)
}