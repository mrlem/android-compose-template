package org.mrlem.composesample.features.library.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.mrlem.composesample.features.library.data.datasources.remote.WikipediaDataSource
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun retrofit(httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://en.wikipedia.org/w/")
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun wikipediaDataSource(retrofit: Retrofit): WikipediaDataSource =
        retrofit.create(WikipediaDataSource::class.java)
}