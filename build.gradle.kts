buildscript {
    repositories {
        //google()
    }
    dependencies {
        //classpath ("com.android.tools.build:gradle:7.4.0")
    }
}

plugins {
    id("com.android.application") version "7.3.0" apply false
    id("com.android.library") version "7.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    kotlin("kapt") version "1.7.20" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
