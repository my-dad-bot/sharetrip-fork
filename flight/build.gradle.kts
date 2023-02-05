plugins {
    id("maven-publish")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "net.sharetrip.flight"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }

    buildTypes {
        release {
            manifestPlaceholders["enableCrashReporting"] = "true"
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    /*flavorDimensions += listOf("platform")

    productFlavors {
        create("sharetrip") {
            dimension = "platform"
        }
        create("banglalink") {
            dimension = "platform"
        }
    }*/

    dataBinding {
        enable = true
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
    implementation(project(":base"))
    implementation(project(":payment"))
    implementation(project(":tracker"))
    implementation(project(":signup"))

    project.retrofit()
    project.core()
    project.coroutines()
    project.lifecycle()
    project.navigation()
    //project.firebase()
    project.converter()
    project.storage()
    project.mixed()
    project.imageLibrary()
    project.annotationProcessor()
    implementation("com.facebook.shimmer:shimmer:0.5.0")
}
