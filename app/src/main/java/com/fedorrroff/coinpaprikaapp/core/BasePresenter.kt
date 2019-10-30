package com.fedorrroff.coinpaprikaapp.core

interface BasePresenter<T : BaseFragment> {

    fun attachView(view: T)

}