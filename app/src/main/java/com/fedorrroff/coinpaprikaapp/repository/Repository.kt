package com.fedorrroff.coinpaprikaapp.repository

import com.fedorrroff.coinpaprikaapp.models.Coin
import io.reactivex.Observable

interface Repository {

    fun getCurrencies() : Observable<List<Coin>>
}