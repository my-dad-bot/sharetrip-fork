@file:Suppress("UnstableApiUsage")

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

fun Project.core() {
    dependencies {
        add("implementation", Libs.kotlin_stdlib_jdk8)
        add("implementation", Libs.androidx_core_ktx)
        add("implementation", Libs.androidx_appcompat)
        add("implementation", Libs.androidx_constraintlayout)
        add("implementation", Libs.google_android_material)
    }
}

fun Project.coroutines() {
    dependencies {
        add("implementation", Libs.kotlinx_coroutines_android)
    }
}

fun Project.retrofit() {
    dependencies {
        add("implementation", Libs.retrofit)
        add("implementation", Libs.converter_moshi)
        add("implementation", Libs.logging_interceptor)
        add("implementation", Libs.stetho)
        add("implementation", Libs.stetho_okhttp3)
    }
}

fun Project.lifecycle() {
    dependencies {
        add("implementation", Libs.lifecycle_livedata_ktx)
        add("implementation", Libs.lifecycle_viewmodel_ktx)
        add("implementation", Libs.lifecycle_viewmodel_savedstate)
    }
}

fun Project.navigation() {
    dependencies {
        add("implementation", Libs.navigation_fragment_ktx)
        add("implementation", Libs.navigation_ui_ktx)
    }
}

fun Project.playServices() {
    dependencies {
        //add("implementation", Libs.google_services)
        add("implementation", Libs.play_services_auth)
        add("implementation", Libs.play_services_maps)
    }
}

fun Project.imageLibrary() {
    dependencies {
        add("implementation", Libs.glide)
    }
}

fun Project.converter() {
    dependencies {
        add("implementation", Libs.gson)
    }
}

fun Project.storage() {
    dependencies {
        add("implementation", Libs.room_runtime)
        add("implementation", Libs.room_ktx)
    }
}

fun Project.facebook() {
    dependencies {
        add("implementation", Libs.facebook_android_sdk)
        add("implementation", Libs.facebook_marketing)
        add("implementation", Libs.stetho)
        add("implementation", Libs.stetho_okhttp3)
        add("implementation", Libs.shimmer)
        add("implementation", Libs.facebook_login)
    }
}

fun Project.firebase() {
    dependencies {
        add("implementation", Libs.firebase_config)
        add("implementation", Libs.firebase_analytics)
        add("implementation", Libs.firebase_messaging)
        add("implementation", Libs.firebase_perf_ktx)
        add("implementation", Libs.firebase_core)
        add("implementation", Libs.firebase_crashlytics)
    }
}

fun Project.mixed() {
    dependencies {
        add("implementation", Libs.spinnerdatepicker)
        add("implementation", Libs.lottie)
        add("implementation", Libs.crystalrangeseekbar)
        add("implementation", Libs.recyclerview_selection)
        add("implementation", Libs.paging_runtime)
        add("implementation", Libs.blurview)
        add("implementation", Libs.sectionedrecyclerviewadapter)
        add("implementation", Libs.bigimageviewer)
        add("implementation", Libs.multidex)
        add("implementation", Libs.ink_page_indicator)
        add("implementation", Libs.android_times_square)
        add("implementation", Libs.calendarview)
        add("implementation", Libs.android_saripaar)
        add("implementation", Libs.circleimageview)
        add("implementation", Libs.leonidslib)
        add("implementation", Libs.dexter)
        add("implementation", Libs.timber)
    }
}

fun Project.testImplementation() {
    dependencies {
        add("implementation", Libs.truth)
        //add("testImplementation", Testing.junit4)
        //add("androidTestImplementation", AndroidX.test.ext.junit)
        //add("androidTestImplementation", Libs.multidex_instrumentation)
        //add("androidTestImplementation", AndroidX.test.espresso.core)
    }
}

fun Project.annotationProcessor() {
    dependencies {
        add("kapt", Libs.glide_compiler)
        add("kapt", Libs.room_compiler)
    }
}

fun Project.workManager() {
    dependencies {
        add("implementation", Libs.work_manager)
    }
}

fun Project.crisp() {
    dependencies {
        add("implementation", Libs.crisp_chat)
    }
}