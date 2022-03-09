# Compose Sample

A project template with the following objectives in mind:

* encourage usage of **modern UI** tools
* make it easy to write new features
* optimize for incremental build
* minimize external deps
* encourage creation of a design system

## Sample features

The following [features](feature) are present as distinct modules:

* filmslist: **UI** listing all films
* filmdetail: **UI** showing the details of a film
* ghibli: **web-service** access to [Studio Ghibli REST API](https://ghibliapi.herokuapp.com)
* favorites: **local storage** access to store favorite films

Aside from this, there is a feature creation [script](feature/create.sh). It creates data domain & ui gradle modules for a new feature.

## Technical stack

* features x layer modularization
* dep injection: **hilt**
* user interface: **compose**
* async: **coroutines** & **flow** 
* database: **room**
* rest apis: **retrofit**
* image loading: **coil**
* build: **kts** gradle scripts + buildSrc to simplify
* design: a design demo app to showcase / discuss / help team member onboarding about the design system
* debugging: **chucker** on-device network traffic logger

## Future

A few ideas among others:

* simplify navigation using [compose destinations](https://proandroiddev.com/compose-destinations-simpler-and-safer-navigation-in-compose-with-no-compromises-74a59c6b727d)
* UI feature template for Android Studio

## About

Author: *Sébastien Guillemin*
