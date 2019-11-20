package com.fedorrroff.coinpaprikaapp.ui.currencies

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fedorrroff.coinpaprikaapp.R
import com.fedorrroff.coinpaprikaapp.core.BaseFragment
import com.fedorrroff.coinpaprikaapp.databinding.CurrenciesFragmentBinding
import com.fedorrroff.coinpaprikaapp.di.FragmentPresenterComponent
import com.fedorrroff.coinpaprikaapp.models.Coin
import com.fedorrroff.coinpaprikaapp.models.Currencies
import javax.inject.Inject


class CurrenciesFragment : BaseFragment() {

    fun newInstance() : CurrenciesFragment = CurrenciesFragment()

    @Inject lateinit var viewModel: CurrenciesViewModel

    override fun injectDependencies(fragmentPresenterComponent: FragmentPresenterComponent) = fragmentPresenterComponent.inject(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currencies_fragment, container, false)
    }

    private lateinit var binding: CurrenciesFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.setContentView(activity as Activity, R.layout.currencies_fragment)
        binding.viewModel = viewModel
        viewModel.bind(this)
        viewModel.initCurrencies()
        setCurrenciesList()
    }

    fun setCurrenciesList() {
        val layoutManager = LinearLayoutManager(context)
        binding.listCoins.layoutManager = layoutManager

        binding.listCoins.adapter = CurrencyAdapter().apply {
            viewModel.currencies.observe(this@CurrenciesFragment, Observer {
                it.let(::addAllItems)
            })
        }
    }
}
