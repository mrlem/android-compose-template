import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginInstantiationException
import org.gradle.kotlin.dsl.findByType
import org.mrlem.sample.compose.gradleplugins.configureAndroidCompose

class AndroidComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            val commonExtension = extensions.run {
                findByType<ApplicationExtension>()
                    ?: findByType<LibraryExtension>()
                    ?: throw PluginInstantiationException("Can only be applied on an android Application or Library")
            }

            commonExtension.apply {
                configureAndroidCompose(this)
            }
        }
    }
}