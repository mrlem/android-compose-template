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
    ":feature:filmslist:ui",
    ":feature:filmdetail:ui",
    ":feature:favorites:data",
    ":feature:favorites:domain",
    ":feature:ghibli:data",
    ":feature:ghibli:domain",
)
