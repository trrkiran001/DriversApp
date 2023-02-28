package com.tirupati.dagger

import com.tirupati.DriversApp
import com.tirupati.network.NetworkModule
import com.tirupati.view.DriversActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AndroidInjectionModule::class,
    NetworkModule::class,
    ViewModelsModule::class
    ]
)
interface AppComponent {

    fun inject(app: DriversApp)

    fun inject(activity: DriversActivity)
}