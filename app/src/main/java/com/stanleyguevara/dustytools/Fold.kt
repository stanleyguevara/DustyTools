package com.stanleyguevara.dustytools

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {

    val flow = flow {
        emit(1)
        delay(100)
        emit(2)
        delay(100)
        emit(3)
        while (true) {
            delay(100)
        }
    }

    runBlocking {
        val item = flow.singleOrNull()
        println("Received $item")
    }
}
