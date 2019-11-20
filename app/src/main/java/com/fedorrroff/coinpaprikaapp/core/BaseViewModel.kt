package com.fedorrroff.coinpaprikaapp.core

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    protected val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}