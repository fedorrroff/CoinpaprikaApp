package com.fedorrroff.coinpaprikaapp.di.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fedorrroff.coinpaprikaapp.ui.currencies.CurrenciesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CurrenciesViewModel::class)
    abstract fun bindCurrenciesViewModel(viewModel: CurrenciesViewModel): ViewModel
}