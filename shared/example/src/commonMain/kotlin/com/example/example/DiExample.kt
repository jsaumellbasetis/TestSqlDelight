package com.example.example

import com.example.core.domain.UseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val ExampleScreenScope = "exampleScreen"

val exampleModule = module {
    factory<UseCase<Unit, Flow<String>>> { GetExampleDataUseCase() }
    scope(named(ExampleScreenScope)) {
        scoped { ExampleViewModel(get(), get()) }
    }
}
