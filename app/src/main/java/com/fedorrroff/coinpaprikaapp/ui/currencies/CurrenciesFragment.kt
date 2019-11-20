package com.fedorrroff.coinpaprikaapp.ui.currencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fedorrroff.coinpaprikaapp.R
import com.fedorrroff.coinpaprikaapp.core.BaseFragment
import com.fedorrroff.coinpaprikaapp.databinding.CurrenciesFragmentBinding
import com.fedorrroff.coinpaprikaapp.di.FragmentPresenterComponent
import javax.inject.Inject


class CurrenciesFragment : BaseFragment() {

    fun newInstance() : CurrenciesFragment = CurrenciesFragment()

    @Inject lateinit var viewModel: CurrenciesViewModel

    private lateinit var binding: CurrenciesFragmentBinding

    override fun injectDependencies(fragmentPresenterComponent: FragmentPresenterComponent) = fragmentPresenterComponent.inject(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.currencies_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this

        viewModel.bind(this)
        setCurrenciesList()
    }

    private fun setCurrenciesList() {
        binding.listCoins.layoutManager = LinearLayoutManager(context)

        binding.listCoins.adapter = CurrencyAdapter().apply {
            viewModel.currencies.observe(this@CurrenciesFragment, Observer {
                it?.let(::addAllItems)
            })
        }
    }
}
