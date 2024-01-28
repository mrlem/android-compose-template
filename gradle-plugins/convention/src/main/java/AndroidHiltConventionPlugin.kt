import org.gradle.api.Plugin
import org.gradle.api.Project
import org.mrlem.sample.compose.gradleplugins.commonExtension
import org.mrlem.sample.compose.gradleplugins.configureAndroidHilt

class AndroidHiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            commonExtension.apply {
                configureAndroidHilt(this)
            }
        }
    }

}