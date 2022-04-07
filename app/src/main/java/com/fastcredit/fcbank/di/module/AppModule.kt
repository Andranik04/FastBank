package com.fastcredit.fcbank.di.module

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fastcredit.fcbank.data.local.DataStoreUtil
import com.fastcredit.fcbank.data.remote.api.ApiService
import com.fastcredit.fcbank.data.remote.interceptors.AddHeaderInterceptor
import com.fastcredit.fcbank.data.remote.interceptors.NetworkConnectionInterceptor
import com.fastcredit.fcbank.data.remote.retrofit.NetworkService
import com.fastcredit.fcbank.di.factory.AppViewModelFactory
import com.fastcredit.fcbank.repository.LoansRepository
import com.fastcredit.fcbank.repository.LoansRepositoryImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
@Module(includes = [AppModule.ProvideViewModel::class])
abstract class AppModule {

    @Module
    class ProvideViewModel {

        @Provides
        @Singleton
        fun provideExecutor(): Executor = Executors.newFixedThreadPool(2)

        @Provides
        @Singleton
        fun provideOkHttpClient(
            addHeaderInterceptor: AddHeaderInterceptor,
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): OkHttpClient =
            NetworkService.initOkHttpClient(addHeaderInterceptor, networkConnectionInterceptor)

        @Provides
        @Singleton
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            NetworkService.initRetrofit(okHttpClient)

        @Provides
        @Singleton
        fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create()

        @Provides
        @Singleton
        fun provideDataStoreUtil(context: Context): DataStoreUtil = DataStoreUtil(context)

        @Provides
        fun provideViewModelFactory(
            providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
        ): ViewModelProvider.Factory = AppViewModelFactory(providers)


        // Repositories

        @Provides
        @Singleton
        fun provideLoansRepository(
            apiService: ApiService
        ): LoansRepository = LoansRepositoryImpl(
                apiService,
                Dispatchers.IO
            )

    }

}