package org.mrlem.sample.compose.features.library.domain.usecases

import org.mrlem.sample.compose.features.library.domain.repositories.NameRepository
import javax.inject.Inject

class SayHelloUseCase @Inject constructor(
    private val nameRepository: NameRepository,
) {

    suspend operator fun invoke(): String =
        "Hello ${nameRepository.getName()}!"

}