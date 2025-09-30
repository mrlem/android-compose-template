@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("gradle-plugins")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "app"
include(
    ":app",
    ":core:di",
    ":core:feature:nav",
    ":core:feature:ui",
    ":features:library:data",
    ":features:library:domain",
    ":features:library:nav",
    ":features:library:ui",
    ":features:overview:nav",
    ":features:overview:ui",
    ":theme",
)
