package org.mrlem.composesample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun httpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originRequest: Request = chain.request()
                val requestWithUserAgent: Request = originRequest.newBuilder()
                    .header("User-Agent", "ComposeSample/1.0 (https://github.com/mrlem/android-compose-template)")
                    .build()
                chain.proceed(requestWithUserAgent)
            }
            .build()

}