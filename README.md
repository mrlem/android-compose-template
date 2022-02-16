# Compose Sample

A project template with the following objectives in mind:

* encourage usage of modern UI tools
* make it easy to write new features
* optimize for incremental build
* minimize external deps
* encourage creation of a design system

Behind the scenes:

* UI: compose
* DI: hilt
* Async: coroutines & flow
* Build:
  - kts gradle scripts
  - buildSrc commons
* Features x layer modularization
* Design: a demo app to showcase / discuss / help team member onboarding

## Future

A few ideas among others:

* Navigation (see this [article](https://proandroiddev.com/compose-destinations-simpler-and-safer-navigation-in-compose-with-no-compromises-74a59c6b727d))
* Provide a basic UI (scaffold)
* Provide :arch:data and add a sample retrofit service in :feature:greeting:data

## About

Author: *Sébastien Guillemin*