package com.example.kmmbase.androidApp.example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.example.ExampleScreenScope
import com.example.example.ExampleViewModel
import com.example.kmmbase.androidApp.core.scopednav.navigation.NoParams
import com.example.kmmbase.androidApp.core.scopednav.navigation.ScreenDestination
import com.example.kmmbase.androidApp.greet

object ExampleScreen : ScreenDestination<NoParams>(pathRoot = ExampleScreenScope)

@Composable
fun ExampleScreen(vm: ExampleViewModel) {
    val data = vm.data.collectAsState("")

    Column(modifier = Modifier.padding(16.dp)) {
        Text(greet())
        Text("UseCase text: ${data.value}")
    }
}
