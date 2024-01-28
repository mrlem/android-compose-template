import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginInstantiationException
import org.gradle.kotlin.dsl.findByType
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