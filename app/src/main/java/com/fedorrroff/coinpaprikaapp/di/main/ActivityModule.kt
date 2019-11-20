package com.fedorrroff.coinpaprikaapp.di.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.fedorrroff.coinpaprikaapp.models.Coin
import com.fedorrroff.coinpaprikaapp.ui.currencies.GetCoinUseCase
import com.fedorrroff.coinpaprikaapp.ui.navigation.Navigator
import com.fedorrroff.coinpaprikaapp.ui.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    fun provideFragmentManager(): FragmentManager {
        return mActivity.supportFragmentManager
    }

    @Provides
    fun provideNavigator(): Navigator {
        return NavigatorImpl(mActivity)
    }
}