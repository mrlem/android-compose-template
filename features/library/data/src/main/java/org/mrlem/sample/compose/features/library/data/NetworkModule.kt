package org.mrlem.sample.compose.features.library.data

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.mrlem.sample.compose.features.library.data.remote.api.SongsApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun retrofit(@ApplicationContext context: Context): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://mrlem.org/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    fun songsApi(retrofit: Retrofit): SongsApi =
        retrofit.create(SongsApi::class.java)

}