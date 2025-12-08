# Compose Sample

[![Release](https://img.shields.io/github/v/release/mrlem/android-compose-template?label=version&sort=semver)](https://github.com/mrlem/android-compose-template/releases)
[![Build](https://github.com/mrlem/android-compose-template/actions/workflows/validate-main.yml/badge.svg)](https://github.com/mrlem/android-compose-template/actions)
[![KtLint](https://img.shields.io/badge/code--style-%E2%9D%A4%20ktlint-FF4081)](https://pinterest.github.io/ktlint/)
[![Detekt](https://img.shields.io/badge/static%20analysis-%F0%9F%94%8D%20detekt-purple)](https://detekt.dev/)

A project template with the following objectives in mind:

* use **modern UI** tools
* use a **single source of truth**
* make it **painless** to write **new features**
* optimized for **incremental build**

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
  * di
  * feature
    * nav
    * ui
  * ui
    * theme
* **features**
  * overview
    * nav
    * ui
  * library
    * data
    * domain
    * nav
    * ui
* **gradle-plugins**

Feature module plugins:

* app.feature.data
* app.feature.domain
* app.feature.nav
* app.feature.ui

Each adds all requirements for the module of a given layer, save the android namespace.

Navigation is using dedicated modules for stronger feature isolation.

## Future

* doc:
  - document appInit task
  - document features creation
* unit tests
* room: migration handling
* di: investigate moving from hilt+autodagger to [metro](https://github.com/ZacSweers/metro) once it gets more mature
