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
            credentials { username = "jp_jqgcf92940b7te9e9hfv15jfks" }
        }
    }
}


rootProject.name = "sharetrip"

include(":base")
include(":flight")
include(":holiday")
include(":hotel")
include(":visa")
//include(":bus")
include(":profile")
include(":tracker")
include(":sharetrip")
include(":signup")
include(":payment")
//include(":tour")
include(":wheel")
include(":shared")
include(":newapp")
