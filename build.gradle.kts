plugins {
    plugins.detekt
    plugins.ktlint
    plugins.updates
}

buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradlePlugins.kotlinGradle)
        classpath(GradlePlugins.androidGradle)
        classpath(GradlePlugins.sqldelightGradle)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}