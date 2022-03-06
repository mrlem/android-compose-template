package org.mrlem.sample.compose.feature.favorites.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import org.mrlem.sample.compose.feature.favorites.data.repository.FavoriteRepositoryImpl
import org.mrlem.sample.compose.feature.favorites.domain.repository.FavoriteRepository
import org.mrlem.sample.compose.feature.favorites.data.Module.Bindings
import org.mrlem.sample.compose.feature.favorites.data.local.FavoriteDatabase
import javax.inject.Singleton

/**
 * Provides the DI a way to build all non-annotated objects for the feature.
 */
@InstallIn(SingletonComponent::class)
@Module(includes = [ Bindings::class ])
class Module {

    @Module
    @DisableInstallInCheck
    interface Bindings {

        @Binds
        fun favoriteRepository(impl: FavoriteRepositoryImpl): FavoriteRepository

    }

    @Provides
    @Singleton
    fun favoriteDao(database: FavoriteDatabase) = database.favoriteDao()

}