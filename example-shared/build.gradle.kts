import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.fromTarget(Java.jvmTarget))
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            resources.srcDirs("${project(":mobius").projectDir}/src/commonMain/composeResources")
            dependencies {
                implementation(libs.kotlin.stdlib)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(libs.lifecycle.runtime)
                implementation(libs.gft.design.system)
                implementation(libs.gft.compose)
                implementation(libs.datetime)
                implementation(project(":mobius"))
            }
        }


        androidMain {
            dependencies {

            }
        }

        iosMain {
            dependencies {

            }
        }
    }
}

android {
    namespace = "com.gft.mobius"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = Java.sourceCompatibility
        targetCompatibility = Java.targetCompatibility
    }
}

compose {
    kotlinCompilerPlugin.set(Compose.kotlinCompilerPlugin)
}
