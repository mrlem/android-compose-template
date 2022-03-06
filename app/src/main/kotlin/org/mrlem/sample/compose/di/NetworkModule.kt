package org.mrlem.sample.compose.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    companion object {
        private const val READ_TIMEOUT = 30
        private const val WRITE_TIMEOUT = 30
        private const val CONNECTION_TIMEOUT = 10
        private const val CACHE_SIZE_BYTES = 10 * 1024 * 1024L // 10 MB
    }

    @Provides
    @Singleton
    fun okHttpClient(cache: Cache): OkHttpClient =
        OkHttpClient().newBuilder()
            .connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .cache(cache)
            .build()

    @Provides
    @Singleton
    internal fun cache(@ApplicationContext context: Context): Cache =
        Cache(
            File(context.cacheDir.absolutePath, "HttpCache"),
            CACHE_SIZE_BYTES,
        )

}