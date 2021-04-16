
plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.kotlin.native.cocoapods")
    id("com.squareup.sqldelight")
}

// CocoaPods requires the podspec to have a version.
version = "1.0"

sqldelight {
    database("AppDatabase") {
        packageName = "com.example.kmmbase.database"
        sourceFolders = listOf("sqldelight")
    }
}

android {
    val versionConfig = Version()
    compileSdkVersion(AndroidSdk.compile)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = versionConfig.versionCode
        versionName = versionConfig.versionName
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-43944
android {
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kotlin {
    val sdkName: String? = System.getenv("SDK_NAME")

    val isiOSDevice = sdkName.orEmpty().startsWith("iphoneos")
    if (isiOSDevice) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }

    android()
//    jvm()

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "Some description for a Kotlin/Native module"
        homepage = "Link to a Kotlin/Native module homepage"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.Coroutines.common) {
                    version {
                        strictly(Versions.coroutines)
                    }
                }
                implementation(Dependencies.SQLDelight.runtime)
                api(project(Modules.Shared.Core))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.Android.lifecycle)
                implementation(Dependencies.SQLDelight.androidDriver)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Dependencies.Test.junit)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Dependencies.SQLDelight.nativeDriver)
            }
        }
        val iosTest by getting
    }
}
