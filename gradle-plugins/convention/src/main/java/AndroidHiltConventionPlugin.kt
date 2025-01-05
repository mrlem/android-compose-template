import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.mrlem.android.core.gradleplugins.applicationExtension
import org.mrlem.android.core.gradleplugins.libs

class AndroidHiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        if (applicationExtension != null) {
            pluginManager.apply(libs.findPlugin("hilt-android").get().get().pluginId)
        }

        pluginManager.apply("com.google.devtools.ksp")

        dependencies {
            add("implementation", libs.findLibrary("hilt-android").get())
            add("ksp", libs.findLibrary("hilt-android-compiler").get())
        }
    }

}