package com.fedorrroff.coinpaprikaapp.di.usecases

import com.fedorrroff.coinpaprikaapp.repository.Repository
import com.fedorrroff.coinpaprikaapp.ui.currencies.GetCoinUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetCoinUseCase(repository: Repository): GetCoinUseCase {
        return GetCoinUseCase(repository)
    }
}