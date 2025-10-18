package org.mrlem.android.core.gradleplugins

import org.gradle.api.Project
import java.io.File
import kotlin.io.path.moveTo

class AppInitializer(
    private val project: Project,
) {

    fun execute(projectName: String, basePackage: String) {
        updateProjectReadme(projectName = projectName)
        updateProjectSettings(projectName = projectName)

        val namespace = updateModuleBuild(path = "app", newModulePackage = basePackage).orEmpty()
        updateModuleStrings(path = "app", projectName = projectName)
        updateModuleSources(path = "app", sourceSet = "main", oldRootPackage = namespace, newRootPackage = basePackage)
        updateModuleSources(path = "app", sourceSet = "androidTest", oldRootPackage = namespace, newRootPackage = basePackage)
        updateModuleSources(path = "app", sourceSet = "test", oldRootPackage = namespace, newRootPackage = basePackage)

        updateModuleBuild(path = "theme", newModulePackage = "$basePackage.theme")
        updateModuleSources(path = "theme", sourceSet = "main", oldRootPackage = namespace, newRootPackage = basePackage)

        project.file("features")
            .listFiles()
            .flatMap { feature ->
                feature
                    .listFiles()
                    .filter { it.isDirectory }
            }
            .forEach { module ->
                val modulePath = "features/${module.parentFile.name}/${module.name}"
                val subPackage = "features.${module.parentFile.name}.${module.name}"
                val newModulePackage = "$basePackage.$subPackage"
                updateModuleBuild(path = modulePath, newModulePackage = newModulePackage)
                updateModuleSources(path = modulePath, sourceSet = "main", oldRootPackage = namespace, newRootPackage = basePackage)
            }
    }

    private fun updateProjectReadme(projectName: String) =
        project.file("readme.md")
            .takeIf { it.exists() }
            ?.run {
                val content = readText()
                    .replaceFirst("# [^\n]+".toRegex(), "# $projectName")
                writeText(content)
                println("Updated readme.md")
            }

    private fun updateProjectSettings(projectName: String) =
        project.file("settings.gradle.kts")
            .takeIf { it.exists() }
            ?.run {
                val content = readText()
                    .replaceFirst("rootProject\\.name = \"[^\"]+\"".toRegex(), "rootProject.name = \"$projectName\"")
                writeText(content)
                println("Updated settings.gradle.kts")
            }

    private fun updateModuleBuild(path: String, newModulePackage: String) =
        project.file("$path/build.gradle.kts")
            .takeIf { it.exists() }
            ?.run {
                val content = readText()
                val namespace = "namespace = \"([^\"]+)\"".toRegex()
                    .find(content)
                    ?.groupValues
                    ?.getOrNull(1)
                content
                    .replaceFirst("applicationId = \"[^\"]+\"".toRegex(), "applicationId = \"$newModulePackage\"")
                    .replaceFirst("namespace = \"[^\"]+\"".toRegex(), "namespace = \"$newModulePackage\"")
                    .let { writeText(it) }
                println("Updated $path/build.gradle.kts")

                namespace
            }

    private fun updateModuleSources(path: String, sourceSet: String, oldRootPackage: String, newRootPackage: String) {
        val oldSubPath = oldRootPackage.replace('.', '/')
            .let { if (path == "app") it else "$it/$path" }
        val newSubPath = newRootPackage.replace('.', '/')
            .let { if (path == "app") it else "$it/$path" }

        // move source files
        val sourceRoot = project.file("$path/src/$sourceSet/java/$oldSubPath")
        val targetRoot = project.file("$path/src/$sourceSet/java/$newSubPath")
        if (!sourceRoot.exists()) {
            println("No sources to update in $path")
            return
        }

        targetRoot.parentFile.mkdirs()
        sourceRoot
            .toPath()
            .moveTo(targetRoot.toPath())
        sourceRoot.clearBranch()

        // change package & imports
        targetRoot.walkBottomUp().forEach { file ->
            if (!file.isFile || file.extension != "kt") return@forEach
            val content = file.readText()
                .replaceFirst("package $oldRootPackage", "package $newRootPackage")
                .replace("import $oldRootPackage", "import $newRootPackage")
            file.writeText(content)
        }

        println("Updated $path source files")
    }

    @Suppress("SameParameterValue")
    private fun updateModuleStrings(path: String, projectName: String) =
        project.file("$path/src/main/res/values/strings.xml")
            .takeIf { it.exists() }
            ?.run {
                val content = readText()
                    .replaceFirst("<string name=\"app_name\">[^<]+</string>".toRegex(), "<string name=\"app_name\">$projectName</string>")
                writeText(content)
                println("Updated $path/src/main/res/values/strings.xml")
            }

    private fun File.clearBranch() {
        if (listFiles().isNullOrEmpty()) {
            delete()
            parentFile.clearBranch()
        }
    }

}