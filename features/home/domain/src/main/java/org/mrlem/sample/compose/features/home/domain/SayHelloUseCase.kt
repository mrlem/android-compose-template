package org.mrlem.sample.compose.features.home.domain

import javax.inject.Inject

class SayHelloUseCase @Inject constructor() {

    suspend operator fun invoke(): String =
        "Hello world!"

}