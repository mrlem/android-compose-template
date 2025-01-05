import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.mrlem.android.core.gradleplugins.libs
import org.mrlem.android.core.gradleplugins.roomExtension

class AndroidRoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        roomExtension?.run {
            schemaDirectory("$projectDir/schemas")
        }

        dependencies {
            add("implementation", libs.findLibrary("androidx-room-runtime").get())
            add("implementation", libs.findLibrary("androidx-room-ktx").get())
            add("ksp", libs.findLibrary("androidx-room-compiler").get())
        }
    }

}