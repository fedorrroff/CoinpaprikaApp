package com.fedorrroff.coinpaprikaapp.ui.currencies

import androidx.lifecycle.*
import com.fedorrroff.coinpaprikaapp.core.BaseViewModel
import com.fedorrroff.coinpaprikaapp.models.Coin
import com.fedorrroff.coinpaprikaapp.ui.navigation.Navigator
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CurrenciesViewModel @Inject constructor(
    private val navigator: Navigator,
    private val useCase: GetCoinUseCase
) : BaseViewModel(), LifecycleObserver{

    val currencies = MutableLiveData<List<Coin>>()

    fun bind(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun initCurrencies() {
        useCase.invoke()
            .subscribeOn(Schedulers.io())
            .subscribeBy { currencies.postValue(it) }
            .addTo(disposables)
    }
}