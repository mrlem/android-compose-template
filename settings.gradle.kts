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
    ":feature:feature3:data",
    ":feature:feature3:domain",
    ":feature:feature3:ui",
    ":feature:feature2:data",
    ":feature:feature2:domain",
    ":feature:feature2:ui",
    ":feature:feature1:data",
    ":feature:feature1:domain",
)
