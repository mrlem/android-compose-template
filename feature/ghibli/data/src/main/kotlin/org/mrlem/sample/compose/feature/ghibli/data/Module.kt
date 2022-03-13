package org.mrlem.sample.compose.feature.ghibli.data

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import okhttp3.OkHttpClient
import org.mrlem.sample.compose.feature.ghibli.data.Module.Bindings
import org.mrlem.sample.compose.feature.ghibli.data.local.GhibliDatabase
import org.mrlem.sample.compose.feature.ghibli.data.remote.GhibliApi
import org.mrlem.sample.compose.feature.ghibli.data.repository.GhibliRepositoryImpl
import org.mrlem.sample.compose.feature.ghibli.domain.repository.GhibliRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Provides the DI a way to build all non-annotated objects for the feature.
 */
@Module(includes = [ Bindings::class ])
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
    fun filmDao(database: GhibliDatabase) = database.filmDao()

    @Provides
    @Singleton
    fun ghibliApi(retrofit: Retrofit): GhibliApi =
        retrofit.create(GhibliApi::class.java)

    @Provides
    @Singleton
    fun retrofit(
        @ApplicationContext context: Context,
        client: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(context.getString(R.string.ghibli_api_baseurl))
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

}