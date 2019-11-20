package com.fedorrroff.coinpaprikaapp.ui.currencies

import com.fedorrroff.coinpaprikaapp.models.Coin
import com.fedorrroff.coinpaprikaapp.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: Repository) {

    fun downloadCurrencies(): Observable<List<Coin>> = repository.getCurrencies()
}