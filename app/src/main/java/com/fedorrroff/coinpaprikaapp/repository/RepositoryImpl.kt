package com.fedorrroff.coinpaprikaapp.repository

import com.fedorrroff.coinpaprikaapp.api.Requester
import com.fedorrroff.coinpaprikaapp.models.Currencies
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl
    @Inject constructor(
        private val currencyResource: Requester
    ): Repository {

    override fun getCurrencies(): Observable<Currencies> = currencyResource
                                                            .getCurrencies()
                                                            .subscribeOn(Schedulers.newThread())
}