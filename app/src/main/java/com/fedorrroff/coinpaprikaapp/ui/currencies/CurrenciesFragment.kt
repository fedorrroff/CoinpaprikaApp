package com.fedorrroff.coinpaprikaapp.ui.currencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fedorrroff.coinpaprikaapp.R
import com.fedorrroff.coinpaprikaapp.core.BaseFragment
import com.fedorrroff.coinpaprikaapp.di.FragmentPresenterComponent
import com.fedorrroff.coinpaprikaapp.models.Currencies
import javax.inject.Inject


class CurrenciesFragment : BaseFragment() {

    private val currencyAdapter: CurrencyAdapter = CurrencyAdapter(emptyList())
    private lateinit var recyclerView: RecyclerView

    fun newInstance() : CurrenciesFragment = CurrenciesFragment()

    @Inject lateinit var currenciesFragmentPresenter: CurrenciesFragmentPresenter

    override fun injectDependencies(fragmentPresenterComponent: FragmentPresenterComponent) = fragmentPresenterComponent.inject(this)

    override fun attachViewToPresenter() = currenciesFragmentPresenter.attachView(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currencies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rw_currencies)

        recyclerView.adapter = currencyAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        currenciesFragmentPresenter.downloadCurrencies()
    }

    fun displayCurrencies(currencies: Currencies) {
        val coins = currencies.coins

        currencyAdapter.addAllItems(currencies.coins)
    }
}
