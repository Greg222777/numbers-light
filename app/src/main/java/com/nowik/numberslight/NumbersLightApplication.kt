package com.nowik.numberslight

import android.app.Application
import com.nowik.numberslight.repositories.NumbersRepository
import com.nowik.numberslight.repositories.NumbersRepositoryImpl
import com.nowik.numberslight.ui.viewmodels.NetworkStateViewModel
import com.nowik.numberslight.service.NumbersNetworkServiceImpl
import com.nowik.numberslight.service.NumbersService
import com.nowik.numberslight.ui.viewmodels.NumberDetailsViewModel
import com.nowik.numberslight.ui.viewmodels.NumbersViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NumbersLightApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@NumbersLightApplication)
            modules(
                module {
                    viewModel { NetworkStateViewModel(androidApplication()) }
                    viewModel { NumbersViewModel(get()) }
                    viewModel { NumberDetailsViewModel(get()) }
                    single<NumbersService> { NumbersNetworkServiceImpl() }
                    single<NumbersRepository> { NumbersRepositoryImpl(get()) }
                }
            )
        }
    }

}
