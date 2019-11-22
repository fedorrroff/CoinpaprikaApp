package com.fedorrroff.coinpaprikaapp.usecases

import com.fedorrroff.coinpaprikaapp.models.Coin
import com.fedorrroff.coinpaprikaapp.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Observable<UseCaseResult> = repository.getCurrencies()
        .map<UseCaseResult> {result -> UseCaseResult.Success(result)}
        .startWith(UseCaseResult.Loading)
        .onErrorReturn(UseCaseResult::Error)

    sealed class UseCaseResult {
        object Loading : UseCaseResult()
        data class Success(val coins: List<Coin>) : UseCaseResult()
        data class Error(val throwable: Throwable) : UseCaseResult()
    }
}