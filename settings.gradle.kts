pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven {
            url = uri("http://dl.bintray.com/piasy/maven")
            isAllowInsecureProtocol = true
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }
}


rootProject.name = "sharetrip"

include(":base")
include(":flight")
//include(":bus")
//include(":profile")
//include(":tracker")
include(":sharetrip")
//include(":signup")
include(":payment")
//include(":tour")
//include(":shared")
include(":newapp")
