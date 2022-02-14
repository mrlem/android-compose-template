# Compose Sample

A project template with the following objectives in mind:

* encourage usage of modern UI tools
* make it easy to write new features
* optimize for incremental build
* minimize external deps

Behind the scenes:

* UI: compose
* DI: hilt
* Async: coroutines & flow
* Build:
  - kts gradle scripts
  - buildSrc commons
* Features x layer modularization

## Future

A few ideas among others:

* Navigation
* Provide a basic UI (toolbar)
* Provide :arch:data and add a sample retrofit service in :feature:greeting:data

## About

Author: *Sébastien Guillemin*