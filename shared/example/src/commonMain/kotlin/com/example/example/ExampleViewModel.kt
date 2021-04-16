package com.example.example

import com.example.core.FrontDispatchers
import com.example.core.domain.UseCase
import com.example.core.ui.ViewController
import kotlinx.coroutines.flow.Flow

class ExampleViewModel(
    dispatchers: FrontDispatchers,
    getExampleDataUseCase: UseCase<Unit, Flow<String>>,
) : ViewController(dispatchers) {

    val data = getExampleDataUseCase(Unit)
}
