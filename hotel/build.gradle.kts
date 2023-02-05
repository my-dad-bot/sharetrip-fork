plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
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
        debug {
            manifestPlaceholders["enableCrashReporting"] = "false"
            isMinifyEnabled = false
        }
    }

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
    implementation(project(":shared"))
    implementation(project(":signup"))
    implementation(project(":payment"))
    implementation(project(":profile"))
    implementation("io.socket:socket.io-client:1.0.0")

    project.retrofit()
    project.coroutines()
    project.core()
    project.lifecycle()
    project.navigation()
    project.playServices()
    project.imageLibrary()
    project.converter()
    project.storage()
    project.facebook()
    project.firebase()
    project.mixed()
    project.annotationProcessor()

}
