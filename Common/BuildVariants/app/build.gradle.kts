plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.softcross.buildvariants"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.softcross.buildvariants"
        minSdk = 26
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
        create("preTest"){


        }
    }

    flavorDimensions += "version"

    productFlavors{
        create("free"){
            manifestPlaceholders["appLabel"] = "Build Variants Free"
            resValue("string", "app_name", "Build Variants Free")
            dimension = "version"
        }
        create("paid"){
            manifestPlaceholders["appLabel"] = "Build Variants Paid"
            resValue("string", "app_name", "Build Variants Paid")
            dimension = "version"
        }
    }

    buildFeatures{
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}