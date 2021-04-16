package com.example.kmmbase.shared

import com.example.example.ExampleScreenScope
import com.example.example.ExampleViewModel
import com.example.kmmbase.shared.base.AppViewModel
import com.example.kmmbase.shared.di.initKoin
import org.koin.core.Koin
import org.koin.dsl.module

fun initDependenciesIos(): DependenciesProvider = initKoin {
    module {}
}.let { DependenciesProvider(it.koin) }

class DependenciesProvider(private val koin: Koin) {
    fun provideAppViewModel(): AppViewModel = koin.get()
    fun provideExampleScope(navParams: String) = ExampleDiScope(navParams, koin)
}

class ExampleDiScope(
    navParams: String,
    koin: Koin
) : DiScope(navParams, ExampleScreenScope, koin) {
    fun provideExampleViewModel(): ExampleViewModel = scope.get()
}
