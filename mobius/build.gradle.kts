import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.gradle.jvm.tasks.Jar

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.ksp)
}

kotlin {
    android {
        namespace = "com.gft.mobius"
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

    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
            dependencies {
                implementation(libs.jetbrains.compose.components.resources)
                implementation(libs.jetbrains.compose.foundation)
                implementation(libs.jetbrains.compose.material3)
                implementation(libs.jetbrains.compose.runtime)
                implementation(libs.jetbrains.compose.ui)

                implementation(libs.androidx.lifecycle.runtime.compose)

                api(libs.kotlinx.datetime)

                implementation(libs.gft.compose)
                implementation(libs.gft.design.system)
                implementation(libs.gft.design.system.codegen)
            }
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.gft.design.system.codegen)
}

tasks.withType<com.google.devtools.ksp.gradle.KspAATask>().configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinNativeCompile>().all {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

tasks.withType<Jar>().configureEach {
    if (name.contains("SourcesJar", ignoreCase = true)) {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

mavenPublishing {
    coordinates(project.property("libraryGroupId") as String, "mobius", project.property("libraryVersion") as String)

    pom {
        name.set(project.property("libraryName") as String)
        description.set(project.property("libraryDescription") as String)
        inceptionYear.set(project.property("libraryInceptionYear") as String)
        url.set("https://${project.property("libraryRepositoryUrl") as String}")
        licenses {
            license {
                name.set(project.property("libraryLicenseName") as String)
                url.set(project.property("libraryLicenseUrl") as String)
                distribution.set(project.property("libraryLicenseDistribution") as String)
            }
        }
        developers {
            developer {
                name.set(project.property("libraryDeveloperName") as String)
            }
        }
        scm {
            url.set("https://${project.property("libraryRepositoryUrl") as String}")
            connection.set("scm:git:git://${project.property("libraryRepositoryUrl") as String}")
            developerConnection.set("scm:git:ssh://git@${project.property("libraryRepositoryUrl") as String}.git")
        }
    }
    publishToMavenCentral()
    signAllPublications()
}
