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

    //project.core()
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.0")

    //project.retrofit()
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    //project.navigation()
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    //project.coroutines()
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    //project.lifecycle()
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    //project.converter()
    implementation("com.google.code.gson:gson:2.10")

    //project.storage()
    implementation("androidx.room:room-runtime:2.4.3")
    implementation("androidx.room:room-ktx:2.4.3")

    //project.mixed()
    implementation("com.github.drawers:SpinnerDatePicker:2.1.0")
    implementation("com.airbnb.android:lottie:5.2.0")
    implementation("com.crystal:crystalrangeseekbar:1.1.3")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")
    implementation("androidx.paging:paging-runtime:3.1.1")
    implementation("com.eightbitlab:blurview:1.6.6")
    implementation("io.github.luizgrp.sectionedrecyclerviewadapter:sectionedrecyclerviewadapter:3.2.0")
    //implementation("com.github.piasy:BigImageViewer:1.7.1")
    implementation ("androidx.multidex:multidex:2.0.1")
    implementation("com.pacioianu.david:ink-page-indicator:1.3.0")
    implementation("com.squareup:android-times-square:1.7.10")
    implementation ("com.github.kizitonwose:CalendarView:0.3.2")
    implementation("com.mobsandgeeks:android-saripaar:2.0.3")
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.plattysoft.leonids:LeonidsLib:1.3.2")
    implementation("com.karumi:dexter:6.2.3")
    implementation("com.jakewharton.timber:timber:5.0.1")

    //project.imageLibrary()
    implementation("com.github.bumptech.glide:glide:4.14.2")

    //project.annotationProcessor()
    kapt("com.github.bumptech.glide:compiler:4.14.2")
    kapt("androidx.room:room-compiler:2.4.3")

    implementation("com.facebook.shimmer:shimmer:0.5.0")
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.github.jubayar"
                artifactId = "flight"
                version = "0.9.4"
            }
        }
    }
}
