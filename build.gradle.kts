buildscript {
    repositories {
        //google()
    }
    dependencies {
        //classpath ("com.android.tools.build:gradle:7.4.0")
    }
}

plugins {
    id("com.android.application") version "7.4.0" apply false
    id("com.android.library") version "7.4.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    kotlin("kapt") version "1.7.20" apply false

    id("com.google.gms.google-services") version "4.3.8" apply false
    id("com.google.firebase.crashlytics") version "2.9.2" apply false
    id("com.google.firebase.firebase-perf") version "1.4.2" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
