// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }

    allprojects {
        plugins.withType(BasePlugin::class.java) {
            afterEvaluate {
                configure<com.android.build.gradle.BaseExtension> {
                    defaultConfig {
                        minSdk = Versions.Sdk.min
                        targetSdk = Versions.Sdk.target
                        setCompileSdkVersion(Versions.Sdk.compile)
                    }
                }

                dependencies {
                    add("implementation", "com.jakewharton.timber:timber:${Versions.timber}")
                }
            }
        }
    }
}

apply(file("gradle/projectDependencyGraph.gradle"))