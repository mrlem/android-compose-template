package org.mrlem.composesample.features.library.domain.usecase

import org.mrlem.composesample.features.library.domain.repositories.BookmarkRepository
import javax.inject.Inject

class ImportRandomBookmark @Inject constructor(
    private val repository: BookmarkRepository,
) {

    suspend operator fun invoke() {
        val randomName = repository.getRandom()
        val bookmark = repository.import(randomName)
        repository.add(bookmark)
    }

}