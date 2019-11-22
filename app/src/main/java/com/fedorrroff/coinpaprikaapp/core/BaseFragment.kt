package com.fedorrroff.coinpaprikaapp.core

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fedorrroff.coinpaprikaapp.di.main.ActivityModule
import com.fedorrroff.coinpaprikaapp.di.main.DaggerMainComponent
import com.fedorrroff.coinpaprikaapp.di.main.MainComponent

abstract class BaseFragment : Fragment(){

    protected fun getMainComponent(): MainComponent {
        return DaggerMainComponent
            .builder()
            .activityModule(ActivityModule(requireActivity() as AppCompatActivity))
            .build()
    }

}