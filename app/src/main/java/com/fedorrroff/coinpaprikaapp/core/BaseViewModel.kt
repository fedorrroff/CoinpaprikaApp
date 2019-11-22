package com.fedorrroff.coinpaprikaapp.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    protected val disposables = CompositeDisposable()
    val loading = MutableLiveData<Boolean>()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    protected fun showLoading() {
        loading.postValue(true)
    }

    protected fun hideLoading() {
        loading.postValue(false)
    }
}