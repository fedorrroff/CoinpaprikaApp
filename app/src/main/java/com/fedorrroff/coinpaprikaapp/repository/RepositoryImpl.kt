package com.fedorrroff.coinpaprikaapp.repository

import com.fedorrroff.coinpaprikaapp.api.Requester
import com.fedorrroff.coinpaprikaapp.models.Coin
import io.reactivex.Observable

class RepositoryImpl(private val currencyResource: Requester) : Repository {

    override fun getCurrencies(): Observable<List<Coin>> = currencyResource.getCurrencies()
}
