plugins {
    id ("maven-publish")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {

    namespace = "com.sharetrip.base"

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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    kapt(Libs.glide_compiler)
    kapt(Libs.room_compiler)

    project.core()
    project.retrofit()
    project.coroutines()
    project.lifecycle()
    project.navigation()
    //project.firebase()
    project.facebook()
    project.playServices()
    project.converter()
    project.storage()
    project.mixed()
    project.imageLibrary()
    project.testImplementation()
    project.annotationProcessor()
    project.workManager()
    project.crisp()
}


afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.github.sharetripnet"
                artifactId = "base"
                version = "0.9.9"
            }
        }
    }
}