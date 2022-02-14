package org.mrlem.sample.compose.feature.greeting.domain

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SampleManager @Inject constructor() {

    private var counter = 0

    fun act() = ++counter

}