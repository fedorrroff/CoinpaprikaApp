package com.fedorrroff.coinpaprikaapp.ui.currencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.fedorrroff.coinpaprikaapp.R
import com.fedorrroff.coinpaprikaapp.core.BaseFragment
import com.fedorrroff.coinpaprikaapp.databinding.CurrenciesFragmentBinding
import javax.inject.Inject


class CurrenciesFragment : BaseFragment() {

    fun newInstance() : CurrenciesFragment = CurrenciesFragment()

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory
    private val viewModel: CurrenciesViewModel by lazy {
        ViewModelProviders.of(this, vmFactory).get(CurrenciesViewModel::class.java)
    }

    private lateinit var binding: CurrenciesFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        getMainComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.currencies_fragment, container, false)
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.bind(this)
        setCurrenciesList()
        return binding.root
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
