package org.mrlem.android.core.feature.nav

interface Destination {

    val target: Target
        get() = Target.DEFAULT

    interface Target {

        companion object {

            val DEFAULT = object : Target {}

        }

    }

}