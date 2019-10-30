package com.fedorrroff.coinpaprikaapp.di.main

import com.fedorrroff.coinpaprikaapp.api.Requester
import com.fedorrroff.coinpaprikaapp.repository.Repository
import com.fedorrroff.coinpaprikaapp.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(requester: Requester): Repository = RepositoryImpl(requester)
}