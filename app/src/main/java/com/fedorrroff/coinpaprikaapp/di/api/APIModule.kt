package com.fedorrroff.coinpaprikaapp.di.api

import com.fedorrroff.coinpaprikaapp.api.APIService
import com.fedorrroff.coinpaprikaapp.api.Requester
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class APIModule {

    companion object {
        const val BASE_ENDPOINT = "https://api.coinpaprika.com/v1/"
    }

    @Provides
    fun provideRequester() : Requester = Requester(getAPIService())

    private fun getAPIService() : APIService = Retrofit
        .Builder()
        .baseUrl(BASE_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(APIService::class.java)
}