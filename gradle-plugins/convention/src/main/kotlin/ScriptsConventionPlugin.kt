import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.mrlem.android.core.gradleplugins.AppInitializer

class ScriptsConventionPlugin : Plugin<Project> {

    private companion object {

        const val TASK_APP_INIT = "appInit"
        const val PARAM_PROJECT_NAME = "projectName"
        const val PARAM_PACKAGE = "package"

    }

    private val appInitException = GradleException("Usage: ./gradlew $TASK_APP_INIT -P$PARAM_PROJECT_NAME=my-project -P$PARAM_PACKAGE=com.example.myproject")

    override fun apply(target: Project) {
        with(target) {
            tasks.register(TASK_APP_INIT) {
                doLast {
                    val initializer = AppInitializer(project)
                    initializer.execute(
                        projectName = project.findProperty(PARAM_PROJECT_NAME)?.toString()
                            ?: throw appInitException,
                        basePackage = project.findProperty(PARAM_PACKAGE)?.toString()
                            ?: throw appInitException,
                    )
                }
            }
        }
    }

}