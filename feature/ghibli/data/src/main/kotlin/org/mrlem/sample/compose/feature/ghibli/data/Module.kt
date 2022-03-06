package org.mrlem.sample.compose.feature.ghibli.data

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import org.mrlem.sample.compose.feature.ghibli.data.Module.Bindings
import org.mrlem.sample.compose.feature.ghibli.data.remote.GhibliApi
import org.mrlem.sample.compose.feature.ghibli.data.repository.GhibliRepositoryImpl
import org.mrlem.sample.compose.feature.ghibli.domain.repository.GhibliRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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
        fun ghibliRepository(impl: GhibliRepositoryImpl): GhibliRepository

    }

    @Provides
    fun ghibliApi(retrofit: Retrofit) = retrofit.create(GhibliApi::class.java)

    @Provides
    fun retrofit(@ApplicationContext context: Context): Retrofit = Retrofit.Builder()
        .baseUrl(context.getString(R.string.ghibli_api_baseurl))
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

}