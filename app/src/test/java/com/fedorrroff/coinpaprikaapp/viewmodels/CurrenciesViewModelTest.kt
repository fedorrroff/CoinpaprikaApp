package com.fedorrroff.coinpaprikaapp.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import com.fedorrroff.coinpaprikaapp.LifecycleOwnerStub
import com.fedorrroff.coinpaprikaapp.models.Coin
import com.fedorrroff.coinpaprikaapp.ui.currencies.CurrenciesViewModel
import com.fedorrroff.coinpaprikaapp.usecases.GetCoinUseCase
import com.fedorrroff.coinpaprikaapp.ui.navigation.Navigator
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CurrenciesViewModelTest {

    @get:Rule var rxJavaTestHooksResetRule = RxJavaTestHooksResetRule()
    @get:Rule var rule: TestRule = InstantTaskExecutorRule()

    @Mock lateinit var getCoinUseCase: GetCoinUseCase
    @Mock lateinit var navigator: Navigator

    private val lifecycleOwner = LifecycleOwnerStub()

    private lateinit var sut: CurrenciesViewModel

    @Before
    fun setUp() {
        sut = CurrenciesViewModel(navigator, getCoinUseCase)
        sut.bind(lifecycleOwner)
    }

    @Test
    fun `initCurrencies should set coin list`() {
        val list = listOf(Coin("11", "Bitcoin", "BTC", 1, false, true, "coin"),
            Coin("11", "Bitcoin", "BTC", 1, false, true, "token"))

        Mockito.`when`(getCoinUseCase.invoke()).thenReturn(Observable.just(GetCoinUseCase.UseCaseResult.Success(list)))

        lifecycleOwner.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        Assert.assertEquals(sut.currencies.value, list)
    }
}
