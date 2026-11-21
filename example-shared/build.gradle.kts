import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    android {
        namespace = "com.gft.mobius.presentation"
        compileSdk {
            version = release(libs.versions.android.compileSdk.get().toInt()) {
                minorApiLevel = libs.versions.android.compileSdkMinor.get().toInt()
            }
        }
        minSdk = libs.versions.android.minSdk.get().toInt()
        androidResources { enable = true }
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(Java.jvmTarget))
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain {
            resources.srcDirs("${project(":mobius").projectDir}/src/commonMain/composeResources")
            dependencies {
                implementation(project(":mobius"))

                implementation(libs.jetbrains.compose.components.resources)
                implementation(libs.jetbrains.compose.foundation)
                implementation(libs.jetbrains.compose.material3)
                implementation(libs.jetbrains.compose.ui)

                implementation(libs.androidx.lifecycle.runtime.compose)

                implementation(libs.kotlinx.datetime)

                implementation(libs.gft.compose)
                implementation(libs.gft.design.system)
            }
        }
    }
}
