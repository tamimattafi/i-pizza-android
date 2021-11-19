package com.tamimattafi.pizza.android.di.modules.data.source.core.remote

import com.tamimattafi.pizza.android.BuildConfig
import com.tamimattafi.pizza.android.data.remote.client.order.IOrderClient
import com.tamimattafi.pizza.android.data.remote.client.pizza.IPizzaClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
object PrimaryClientModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePizzaClient(retrofit: Retrofit): IPizzaClient =
        retrofit.create(IPizzaClient::class.java)

    @Provides
    @Singleton
    fun provideOrdersClient(retrofit: Retrofit): IOrderClient =
        retrofit.create(IOrderClient::class.java)
}