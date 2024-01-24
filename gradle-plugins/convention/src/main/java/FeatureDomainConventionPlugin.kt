import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.mrlem.sample.compose.gradleplugins.libs

class FeatureDomainConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("app.android.library")
            }

            dependencies {
                add("implementation", libs.findLibrary("inject").get())
            }
        }
    }

}