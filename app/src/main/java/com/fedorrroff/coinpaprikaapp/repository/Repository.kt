package com.fedorrroff.coinpaprikaapp.repository

import com.fedorrroff.coinpaprikaapp.models.Coin
import com.fedorrroff.coinpaprikaapp.models.Currencies
import io.reactivex.Observable

interface Repository {

    fun getCurrencies() : Observable<List<Coin>>
}