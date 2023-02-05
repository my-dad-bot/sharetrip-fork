plugins {
    id("com.android.library")
    id("common-module-plugin")
    id("kotlin-android")
}

android {
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
    implementation(project(":payment"))
}
