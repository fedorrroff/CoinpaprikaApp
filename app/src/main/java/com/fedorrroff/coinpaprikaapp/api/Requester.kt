package com.fedorrroff.coinpaprikaapp.api

import com.fedorrroff.coinpaprikaapp.models.Coin
import io.reactivex.Observable

class Requester(private val apiService: APIService) {

    fun getCurrencies(): Observable<List<Coin>> {
        apiService.getCurrencies()
        return apiService.getCurrencies()
    }
}
