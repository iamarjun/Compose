plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.jetpackcompose"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "AUTH_TOKEN",
            "\"Token 9c8b06d329136da358c2d00e76946b0111ce2c48\""
        )
        buildConfigField("String", "BASE_URL", "\"https://food2fork.ca/api/recipe/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-beta04"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.3.2")
    implementation("com.google.android.material:material:1.3.0")

    implementation("androidx.appcompat:appcompat:1.3.0-rc01")

    implementation("androidx.compose.ui:ui:1.0.0-beta04")
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta04")
    implementation("androidx.compose.foundation:foundation:1.0.0-beta04")
    implementation("androidx.compose.material:material:1.0.0-beta04")
    implementation("androidx.compose.material:material-icons-core:1.0.0-beta04")
    implementation("androidx.compose.material:material-icons-extended:1.0.0-beta04")
    implementation("androidx.activity:activity-compose:1.3.0-alpha05")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha03")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta04")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.0.0-beta04")

    implementation("androidx.ui:ui-tooling:1.0.0-alpha07")

    implementation("androidx.navigation:navigation-fragment-ktx:2.3.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.4")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.google.dagger:hilt-android:2.33-beta")
    kapt("com.google.dagger:hilt-compiler:2.33-beta")

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

    implementation("com.google.accompanist:accompanist-glide:0.7.0")
}