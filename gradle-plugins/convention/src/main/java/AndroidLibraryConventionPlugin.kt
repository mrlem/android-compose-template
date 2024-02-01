import org.gradle.api.Plugin
import org.gradle.api.Project
import org.mrlem.android.core.gradleplugins.commonExtension
import org.mrlem.android.core.gradleplugins.configureKotlin
import org.mrlem.android.core.gradleplugins.configureKotlinAndroid

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            commonExtension.apply {
                configureKotlin()
                configureKotlinAndroid(this)
            }
        }
    }

}