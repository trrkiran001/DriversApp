package com.tirupati

import android.app.Application
import com.tirupati.dagger.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import com.tirupati.dagger.DaggerAppComponent

class DriversApp: Application(), HasAndroidInjector {

    companion object {
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .build()

        appComponent.inject(this@DriversApp)
    }


    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}