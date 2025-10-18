import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.mrlem.android.core.gradleplugins.AppInitializer
import org.mrlem.android.core.gradleplugins.FeatureGenerator

class ScriptsConventionPlugin : Plugin<Project> {

    private companion object {

        const val TASK_APP_INIT = "appInit"
        const val PARAM_PROJECT_NAME = "projectName"
        const val PARAM_PACKAGE = "package"

        const val TASK_NEW_FEATURE = "appNewFeature"
        const val PARAM_FEATURE_NAME = "featureName"

    }

    private val appInitException = GradleException("Usage: ./gradlew $TASK_APP_INIT -P$PARAM_PROJECT_NAME=my-project -P$PARAM_PACKAGE=com.example.myproject")
    private val appNewFeatureException = GradleException("Usage: ./gradlew $TASK_NEW_FEATURE -P$PARAM_FEATURE_NAME=my-feature")

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

            tasks.register(TASK_NEW_FEATURE) {
                doLast {
                    val generator = FeatureGenerator(project)
                    generator.execute(
                        featureName = project.findProperty(PARAM_FEATURE_NAME)?.toString()
                            ?: throw appNewFeatureException,
                    )
                }
            }
        }
    }

}