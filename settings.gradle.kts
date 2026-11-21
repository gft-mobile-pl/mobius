pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }
}

rootProject.name = "Mobius"
include(":example-android")
include(":example-kmp-android")
include(":mobius")
include(":example-shared")
