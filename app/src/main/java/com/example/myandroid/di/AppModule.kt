package com.example.myandroid.di

import com.example.myandroid.ui.network.NetworkViewModel
import com.example.myandroid.data.UserApi
import com.example.myandroid.data.UserRepository
import com.example.myandroid.network.provideLoggingInterceptor
import com.example.myandroid.network.provideOkHttpClient
import com.example.myandroid.network.provideRetrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single { get<Retrofit>().create(UserApi::class.java) }
    single { UserRepository(get()) }
    viewModel { NetworkViewModel(get()) }
}

val networkModule = module {
    factory { provideLoggingInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideRetrofit(get()) }
}