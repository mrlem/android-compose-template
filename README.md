# Compose Sample

A project template with the following objectives in mind:

* encourage usage of **modern UI** tools
* encourage creation of a design system
* use a single source of truth
* make it easy to write new features
* optimize for incremental build
* minimize external deps


## Sample features

The following [features](feature) are present as distinct modules:

* filmslist: **UI** listing all films
* filmdetail: **UI** showing the details of a film
* ghibli: **web-service** access to [Studio Ghibli REST API](https://ghibliapi.herokuapp.com) & **local storage** for cache

Aside from this, there is a feature creation [script](feature/create.sh). It creates data domain & ui gradle modules for a new feature.

## Technical stack

* features x layer modularization
* build: **kts** gradle scripts + buildSrc to simplify
* dep injection: **hilt**
* user interface: **compose**
* async: **coroutines** & **flow** 
* database: **room**
* rest apis: **retrofit**
* image loading: **coil**
* debugging: **chucker** on-device network traffic logger
* nav animation: **google accompanist**
* design: a design demo app to showcase / discuss / help team member onboarding about the design system

## Future

A few ideas among others:

* simplify navigation using [compose destinations](https://proandroiddev.com/compose-destinations-simpler-and-safer-navigation-in-compose-with-no-compromises-74a59c6b727d) or [safe-compose-args](https://github.com/dilrajsingh1997/safe-compose-args)
* UI feature template for Android Studio
* Replace buildSrc dependencies version handling with [version catalog](https://sourcediving.com/manage-your-gradle-dependencies-with-version-catalog-not-only-in-android-114117647cdb)

## About

Author: *Sébastien Guillemin*
