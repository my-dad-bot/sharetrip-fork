plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = 33
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        versionCode = 150
        versionName = "3.0.0"

        multiDexEnabled = true
        renderscriptTargetApi = 30
        renderscriptSupportModeEnabled = true

        missingDimensionStrategy("platform","sharetrip", "banglalink")
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            manifestPlaceholders["enableCrashReporting"] = "true"
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFile("proguard-rules.pro")
            isCrunchPngs = true

        }
        debug {
            manifestPlaceholders["enableCrashReporting"] = "false"
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFile("proguard-rules.pro")
            isCrunchPngs = false
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
    //implementation(project(":bus"))
    implementation(project(":flight"))
    //implementation(project(":holiday"))
    //implementation(project(":hotel"))
    //implementation(project(":visa"))
    //implementation project(path: ':tour')
    //implementation(project(":signup"))
    //implementation(project(":wheel"))
    //implementation(project(":tracker"))
    //implementation(project(":profile"))
    implementation("io.socket:socket.io-client:1.0.0") {
        exclude(
            group = "org.json",
            module = "json"
        )
    }

    project.retrofit()
    project.core()
    project.coroutines()
    project.lifecycle()
    project.navigation()
    project.firebase()
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
