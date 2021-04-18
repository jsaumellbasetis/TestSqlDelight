object Versions {
    // Kotlin
    const val kotlin = "1.4.31"
    const val kotlinCoroutines = "1.4.3-native-mt"
    const val koin = "3.0.1-beta-1"
    const val coroutines = "1.4.3-native-mt"
    const val detekt = "1.16.0-RC3"

    // UI
    const val lifecycle = "2.3.1"
    const val compose = "1.0.0-beta01"
    const val activity_compose = "1.3.0-alpha03"
    const val nav_compose = "1.0.0-alpha08"
    const val accompanist = "0.6.0"

    // Android Gradle Plugin
    const val androidGradle = "7.0.0-alpha14"


    // Other
    const val sqldelight = "1.4.4"
    const val kermit = "0.1.8"

    const val junit = "4.13"
}

object GradlePlugins {
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
    const val sqldelightGradle = "com.squareup.sqldelight:gradle-plugin:${Versions.sqldelight}"
}

object Dependencies {

    object Coroutines {
        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
        const val runtimeSaveable = "androidx.compose.runtime:runtime-saveable:${Versions.compose}"
        const val activity = "androidx.activity:activity-compose:${Versions.activity_compose}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.nav_compose}"
        const val accompanist= "dev.chrisbanes.accompanist:accompanist-coil:${Versions.accompanist}"
    }

    object Android {
        const val lifecycleSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
        const val lifecycle = "androidx.lifecycle:lifecycle-common:${Versions.lifecycle}"
    }

    object SQLDelight {
        const val runtime = "com.squareup.sqldelight:runtime:${Versions.sqldelight}"
        const val androidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqldelight}"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqldelight}"
    }

    object Other {
        const val kermit = "co.touchlab:kermit:${Versions.kermit}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
    }
}

object DependencyGroups {
    val compose = listOf(
        Dependencies.Compose.ui,
        Dependencies.Compose.uiGraphics,
        Dependencies.Compose.uiTooling,
        Dependencies.Compose.foundationLayout,
        Dependencies.Compose.material,
        Dependencies.Compose.runtimeLiveData,
        Dependencies.Compose.activity,
        Dependencies.Compose.navigation,
        Dependencies.Compose.accompanist
    )

    val koin = listOf(
        Dependencies.Koin.android,
        Dependencies.Koin.compose
    )
}

object Modules {
    const val App = "androidApp"
    object Shared {
        const val root = ":shared"
        const val Core = ":shared:core"
        const val Example = ":shared:example"
    }
}