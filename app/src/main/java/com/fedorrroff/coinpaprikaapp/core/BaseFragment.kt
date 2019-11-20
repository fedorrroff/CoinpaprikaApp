package com.fedorrroff.coinpaprikaapp.core

import androidx.fragment.app.Fragment
import android.os.Bundle
import com.fedorrroff.coinpaprikaapp.di.DaggerFragmentPresenterComponent
import com.fedorrroff.coinpaprikaapp.di.FragmentPresenterComponent
import com.fedorrroff.coinpaprikaapp.di.main.MainComponentHolder

abstract class BaseFragment : Fragment(){

    protected fun getPresenterComponent(): FragmentPresenterComponent {
        return DaggerFragmentPresenterComponent
            .builder()
            .mainComponent(MainComponentHolder.getInstance().getMainComponent())
            .build()
    }

    protected abstract fun injectDependencies(fragmentPresenterComponent: FragmentPresenterComponent)

//    abstract fun attachViewToPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(getPresenterComponent())
//        attachViewToPresenter()
    }
}