package com.fedorrroff.coinpaprikaapp.ui.currencies

import android.util.Log
import com.fedorrroff.coinpaprikaapp.core.BasePresenter
import com.fedorrroff.coinpaprikaapp.repository.Repository
import com.fedorrroff.coinpaprikaapp.ui.navigation.Navigator
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CurrenciesFragmentPresenter
    @Inject constructor(
        navigator: Navigator,
        repository: Repository
    ) : BasePresenter<CurrenciesFragment> {

    private lateinit var mView : CurrenciesFragment
    private val mNavigator = navigator
    private val mRepository = repository

    override fun attachView(view: CurrenciesFragment) {
        mView = view
    }

    fun downloadCurrencies() {
        mRepository.getCurrencies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy (
                onNext =  {currencies -> mView.displayCurrencies(currencies) },
                onError = {e -> e.printStackTrace()}
                )
    }
}