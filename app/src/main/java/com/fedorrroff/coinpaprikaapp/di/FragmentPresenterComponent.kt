package com.fedorrroff.coinpaprikaapp.di

import com.fedorrroff.coinpaprikaapp.di.api.APIModule
import com.fedorrroff.coinpaprikaapp.di.main.MainComponent
import com.fedorrroff.coinpaprikaapp.ui.currencies.CurrenciesFragment
import dagger.Component

@Component(dependencies = arrayOf(MainComponent::class))
interface FragmentPresenterComponent {

    fun inject(view: CurrenciesFragment)

}