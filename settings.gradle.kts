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
    ":core:feature:ui",
    ":core:ui:theme",
    ":features:about:ui",
    ":features:home:ui",
    ":features:home:domain",
    ":features:home:data",
)
