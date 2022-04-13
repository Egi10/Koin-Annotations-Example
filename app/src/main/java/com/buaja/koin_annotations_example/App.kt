package com.buaja.koin_annotations_example

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.AppModuleModule
import org.koin.ksp.generated.NetworkModuleModule


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
                    AppModuleModule,
                    NetworkModuleModule,
                )
            )
        }
    }
}