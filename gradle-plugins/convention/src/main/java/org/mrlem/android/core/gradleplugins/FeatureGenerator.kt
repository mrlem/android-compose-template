package org.mrlem.android.core.gradleplugins

import org.gradle.api.Project

class FeatureGenerator(project: Project) {

    fun execute(featureName: String) {
        println("plop: feature generator $featureName")
    }

}