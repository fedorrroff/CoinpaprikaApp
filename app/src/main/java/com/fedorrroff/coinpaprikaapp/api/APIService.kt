package com.fedorrroff.coinpaprikaapp.api

import com.fedorrroff.coinpaprikaapp.models.Coin
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {

    @GET( "coins")
    fun getCurrencies() : Observable<List<Coin>>
}