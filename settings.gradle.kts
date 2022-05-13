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
    ":feature:feature3:all",
    ":feature:feature2:all",
    ":feature:feature1:all",
)
