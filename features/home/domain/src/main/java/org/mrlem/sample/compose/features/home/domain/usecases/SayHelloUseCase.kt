package org.mrlem.sample.compose.features.home.domain.usecases

import org.mrlem.sample.compose.features.home.domain.repositories.NameRepository
import javax.inject.Inject

class SayHelloUseCase @Inject constructor(
    private val nameRepository: NameRepository,
) {

    suspend operator fun invoke(): String =
        "Hello ${nameRepository.getName()}!"

}