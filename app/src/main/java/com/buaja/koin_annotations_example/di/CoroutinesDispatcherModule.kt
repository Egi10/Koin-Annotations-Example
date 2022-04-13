package com.buaja.koin_annotations_example.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single


/**
 * @created 11/04/22 07.14
 * @author Julsapargi Nursam
 * @project Koin-Annotations-Example
 **/

@Module
class CoroutinesDispatcherModule {
    @Single
    @Named("DefaultDispatcher")
    fun defaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Single
    @Named("IoDispatcher")
    fun ioDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Single
    @Named("MainDispatcher")
    fun mainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}