# Compose Sample

A project template with the following objectives in mind:

* use **modern UI** tools
* use a **single source of truth**
* make it **painless** to write **new features**
* optimize for **incremental build**

## Technical stack

* arch:
  - app: clean architecture with **features x layer modularization**
  - ui: simplified **MVI**
* build: **kts** gradle build scripts + gradle **convention plugins** to simplify + **version catalog**
* dep injection: **hilt** + **auto-dagger**
* ui: **compose** + **material3** + navigation
* async: **coroutines** & **flow**
* db: **room**
* rest: **retrofit**
* annotation processing: **ksp** only, no kapt

## App structure

Modules hierarchy:

* **app**
* **core**
  * feature
    * nav
    * ui
  * ui
    * theme
* **features**
  * library
    * data
    * domain
    * nav
    * ui
  * spotlight
    * ui
* **gradle-plugins**

Feature module plugins:

* app.feature.data
* app.feature.domain
* app.feature.nav
* app.feature.ui

Each adds all requirements for the module of a given layer, save the android namespace.

Navigation is using dedicated modules for stronger feature isolation.

## TODO

* ui: coil
* room: database in the library module makes sense for this sample app, for not for a real app. If
  you find a multi-module pattern for room, please call me (I'd say this is not possible, by design)
* room: migration handling
* data: inject coroutine scope
* vm: allow shared vms in a given navigationGraph
