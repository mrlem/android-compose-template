@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Compose Sample"
include(
    ":app",
    ":arch:data",
    ":arch:domain",
    ":arch:ui",
    ":design:demo",
    ":design:theme",
    // new features
    ":feature:ghibli:data",
    ":feature:ghibli:domain",
    ":feature:greeting:data",
    ":feature:greeting:domain",
    ":feature:greeting:ui",
)
