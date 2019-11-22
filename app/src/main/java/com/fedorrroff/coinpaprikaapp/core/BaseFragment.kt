package com.fedorrroff.coinpaprikaapp.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fedorrroff.coinpaprikaapp.di.main.DaggerMainComponent
import com.fedorrroff.coinpaprikaapp.di.main.MainComponent

abstract class BaseFragment : Fragment(){

    protected fun getMainComponent(): MainComponent {
        return DaggerMainComponent
            .builder()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}