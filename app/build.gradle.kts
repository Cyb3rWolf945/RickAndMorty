plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "pt.ipt.dam.rickyandmorty"
    compileSdk = 35

    defaultConfig {
        applicationId = "pt.ipt.dam.rickyandmorty"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    val moshi_version = "1.9.3"
    val retrofit_version = "2.9.0"
    val lifecycle_version = "2.4.0-alpha02"

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    //moshi
    implementation("com.squareup.moshi:moshi-kotlin:$moshi_version")
    //Retrofit with moshi
    implementation("com.squareup.retrofit2:converter-moshi:$retrofit_version")
    //coil
    implementation("io.coil-kt:coil:1.3.0")

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    // Live Data - observable
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}