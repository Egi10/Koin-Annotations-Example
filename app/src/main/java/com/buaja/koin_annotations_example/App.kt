package com.buaja.koin_annotations_example

import android.app.Application
import com.buaja.koin_annotations_example.di.AppModule
import com.buaja.koin_annotations_example.di.CoroutinesDispatcherModule
import com.buaja.koin_annotations_example.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module


/**
 * @created 11/04/22 05.13
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    AppModule().module,
                    CoroutinesDispatcherModule().module,
                    NetworkModule().module
                )
            )
        }
    }
}