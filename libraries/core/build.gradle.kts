import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.realm)
    alias(libs.plugins.buildKonfig)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "core"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            api(libs.kotlin.coroutine)
            api(libs.ktor.client.core)
            api(libs.ktor.client.content.negotiation)
            api(libs.ktor.client.serialization)
            api(libs.ktor.client.logging)

            api(libs.realm)
            api(libs.realmKotlinSync)
            api(libs.multiplatformSettings)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            api(libs.kermit.logging)
        }

        androidMain.dependencies {
            api(libs.android.viewmodel)
            api(libs.android.viewmodel.compose)
            api(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            api(libs.ktor.client.darwin)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "abika.sinau.libraries.core"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

buildkonfig {
    packageName = "abika.sinau.movieapp"

    // default config is required
    defaultConfigs {
        buildConfigField(STRING, "BASE_URL", "https://api.themoviedb.org/3/")
        buildConfigField(
            STRING,
            "API_KEY",
            gradleLocalProperties(rootDir).getProperty("api_key") ?: ""
        )
    }
}