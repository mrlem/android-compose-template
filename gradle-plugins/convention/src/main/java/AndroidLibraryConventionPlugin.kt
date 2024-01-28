import org.gradle.api.Plugin
import org.gradle.api.Project
import org.mrlem.sample.compose.gradleplugins.commonExtension
import org.mrlem.sample.compose.gradleplugins.configureKotlin
import org.mrlem.sample.compose.gradleplugins.configureKotlinAndroid

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