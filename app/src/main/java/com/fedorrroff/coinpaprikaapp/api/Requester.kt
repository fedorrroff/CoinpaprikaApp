package com.fedorrroff.coinpaprikaapp.api

import com.fedorrroff.coinpaprikaapp.models.Currencies
import io.reactivex.Observable

class Requester(private val apiService: APIService) {

    fun getCurrencies(): Observable<Currencies> {
        apiService.getCurrencies()
        return apiService.getCurrencies()
    }
}
