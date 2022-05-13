package org.mrlem.sample.compose.feature.feature2.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import org.mrlem.sample.compose.feature.feature2.data.local.dao.GhibliDatabase
import org.mrlem.sample.compose.feature.feature2.data.remote.api.GhibliApi
import org.mrlem.sample.compose.feature.feature2.data.repository.GhibliRepositoryImpl
import org.mrlem.sample.compose.feature.feature2.domain.repository.GhibliRepository
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Provides the DI a way to build all non-annotated objects for the feature.
 */
@Module(includes = [ org.mrlem.sample.compose.feature.feature2.data.Module.Bindings::class ])
@InstallIn(SingletonComponent::class)
@Suppress("unused")
class Module {

    @Module
    @DisableInstallInCheck
    interface Bindings {

        @Binds
        fun ghibliRepository(impl: GhibliRepositoryImpl): GhibliRepository

    }

    @Provides
    @Singleton
    fun filmDao(database: GhibliDatabase) = database.film2Dao()

    @Provides
    @Singleton
    fun ghibliApi(retrofit: Retrofit): GhibliApi =
        retrofit.create(GhibliApi::class.java)

}