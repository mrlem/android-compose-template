package org.mrlem.composesample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.mrlem.android.core.di.ApplicationScope
import org.mrlem.android.core.feature.nav.Navigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @Singleton
    @Provides
    fun provideNavigator() = Navigator()

    @Singleton
    @Provides
    @ApplicationScope
    fun provideApplicationScope() = applicationScope

}