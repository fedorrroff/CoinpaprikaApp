package com.fedorrroff.coinpaprikaapp.viewmodels

import RxJavaTestHooksResetRule
import com.fedorrroff.coinpaprikaapp.models.Coin
import com.fedorrroff.coinpaprikaapp.repository.RepositoryImpl
import com.fedorrroff.coinpaprikaapp.usecases.GetCoinUseCase
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCoinUseCaseTest {

    @get:Rule var rxJavaTestHooksResetRule = RxJavaTestHooksResetRule()

    @Mock lateinit var repository: RepositoryImpl

    private lateinit var sut: GetCoinUseCase

    @Before
    fun setUp() {
        sut = GetCoinUseCase(repository)
    }

    @Test
    fun `invoke should emit Loading event upon subscription`() {
        val list = listOf(
            Coin("11", "Bitcoin", "BTC", 1, false, true, "coin"),
            Coin("11", "Bitcoin", "BTC", 1, false, true, "token")
        )

        Mockito.`when`(repository.getCurrencies()).thenReturn(Observable.just(list))

        sut().test().assertValueAt(0) { it is GetCoinUseCase.UseCaseResult.Loading}
    }

    @Test
    fun `invoke should emit LoadingError event when connectivity has been lost`() {
        Mockito.`when`(repository.getCurrencies()).thenReturn(Observable.error(Throwable()))

        sut().test().assertValueAt(1) { it is GetCoinUseCase.UseCaseResult.Error}
    }

    @Test
    fun `invoke should emit Success event when downloading is succeed`() {
        val list = listOf(
            Coin("11", "Bitcoin", "BTC", 1, false, true, "coin"),
            Coin("11", "Bitcoin", "BTC", 1, false, true, "token")
        )

        Mockito.`when`(repository.getCurrencies()).thenReturn(Observable.just(list))

        sut().test().assertValueAt(1, GetCoinUseCase.UseCaseResult.Success(list))
    }
}
