package com.fedorrroff.coinpaprikaapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fedorrroff.coinpaprikaapp.R
import com.fedorrroff.coinpaprikaapp.di.main.MainComponentHolder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainComponentHolder = MainComponentHolder.getInstance()
        mainComponentHolder.initDaggerComponent(this)

        if (savedInstanceState == null) {
            mainComponentHolder.getMainComponent().navigator().showMainScreen()
        }
    }
}
