# DONE

* recent compose application
* gradle convention plugin for shorter build files
* features modularization
* toml version catalog
* vm
* domain layer
* data layer
* di: hilt
* reactive: rx or kotlin flow
* compose navigation
* navigation: several screens
* navigation: contribute per module
* library: list of artists
* library: add artist page
* spotlight: link to an artist
* navigation: should originate from vm
* navigation: add type safe destinations from nav to vm
* data layer: room for persistence

# TODO

* room: database in the library module makes sense for this sample app, for not for a real app. If
  you find a multi-module pattern for room, please call me (I'd say this is not possible, by design)
* room: migration handling
* data: inject coroutine scope
* library: add breadcrumb (e.g. "Library > Muse >")
* data layer: retrofit for api access
* vm: allow shared vms in a given navigationGraph