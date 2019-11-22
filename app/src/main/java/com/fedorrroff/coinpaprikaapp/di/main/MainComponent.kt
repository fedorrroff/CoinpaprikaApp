package com.fedorrroff.coinpaprikaapp.di.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.fedorrroff.coinpaprikaapp.api.Requester
import com.fedorrroff.coinpaprikaapp.di.api.APIModule
import com.fedorrroff.coinpaprikaapp.repository.Repository
import com.fedorrroff.coinpaprikaapp.ui.navigation.Navigator
import com.fedorrroff.coinpaprikaapp.usecases.GetCoinsUseCase
import dagger.Component

@Component(modules = [ActivityModule::class, APIModule::class, RepositoryModule::class, ViewModelModule::class])
interface MainComponent {

    fun activity() : AppCompatActivity

    fun fragmentManager() : FragmentManager

    fun navigator() : Navigator

    fun requester() : Requester

    fun repository() : Repository

    fun getCoinUseCase() : GetCoinUseCase
}