package com.fedorrroff.coinpaprikaapp

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class LifecycleRegistryStub(owner: LifecycleOwner) : LifecycleRegistry(owner) {
    private var state: State = State.INITIALIZED
    private val observers = HashSet<LifecycleObserver>()

    override fun addObserver(observer: LifecycleObserver) {
        super.addObserver(observer)
        observers.add(observer)
    }

    override fun removeObserver(observer: LifecycleObserver) {
        super.removeObserver(observer)
        observers.remove(observer)
    }

    fun checkObserverWasAdded(observer: LifecycleObserver) = observers.contains(observer)

    fun checkObserverWasRemoved(observer: LifecycleObserver) = !observers.contains(observer)

    override fun getCurrentState(): State = state
}