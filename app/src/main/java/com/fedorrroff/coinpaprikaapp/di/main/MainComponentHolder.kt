package com.fedorrroff.coinpaprikaapp.di.main

import androidx.appcompat.app.AppCompatActivity

class MainComponentHolder {

    private lateinit var mainComponent: MainComponent

    companion object {
        fun getInstance() = InstanceHolder.INSTANCE
    }

    fun getMainComponent() = mainComponent

    fun initDaggerComponent(activity: AppCompatActivity) {

        mainComponent = DaggerMainComponent.builder()
            .activityModule(ActivityModule(activity))
            .build()
    }

    class InstanceHolder {
        companion object {
            val INSTANCE = MainComponentHolder()
        }
    }
}