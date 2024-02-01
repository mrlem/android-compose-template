import org.gradle.api.Plugin
import org.gradle.api.Project
import org.mrlem.android.core.gradleplugins.commonExtension
import org.mrlem.android.core.gradleplugins.configureAndroidCompose

class AndroidComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            commonExtension.apply {
                configureAndroidCompose(this)
            }
        }
    }

}