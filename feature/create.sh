#!/bin/sh

# inputs
# .. user
NAME=$1
# .. calculated
MARKER="new features"
PACKAGE=$( find ../app -name MainActivity.kt | xargs cat | grep package | sed "s/package //" )

# preliminary checks
if [ -z "$NAME" ]; then
  echo "usage $0 feature_name"
  exit 1
fi

if [ -z "$PACKAGE" ]; then
  echo "package not found in main activity"
  exit 1
fi

# create dirs
PACKAGE_PATH=$( echo $PACKAGE | sed "s/\./\//g" )
mkdir -p $NAME/data/src/main/kotlin/$PACKAGE_PATH/feature/$NAME/data/dao
mkdir -p $NAME/data/src/main/kotlin/$PACKAGE_PATH/feature/$NAME/data/entity
mkdir -p $NAME/data/src/main/kotlin/$PACKAGE_PATH/feature/$NAME/data/repository
mkdir -p $NAME/domain/src/main/kotlin/$PACKAGE_PATH/feature/$NAME/domain/model
mkdir -p $NAME/domain/src/main/kotlin/$PACKAGE_PATH/feature/$NAME/domain/repository
mkdir -p $NAME/ui/src/main/kotlin/$PACKAGE_PATH/feature/$NAME/ui

# add modules in settings gradle file
MODULES="\n    \":feature:$NAME:data\",\n    \":feature:$NAME:domain\",\n    \":feature:$NAME:ui\","
cat ../settings.gradle.kts | sed "s/$MARKER/$MARKER$MODULES/g" > settings.gradle.kts
rm -f ../settings.gradle.kts
mv settings.gradle.kts ../settings.gradle.kts

# add modules in app gradle file
MODULES="\n    implementation(project(\":feature:$NAME:data\"))\n    implementation(project(\":feature:$NAME:ui\"))"
cat ../app/build.gradle.kts | sed "s/$MARKER/$MARKER$MODULES/g" > build.gradle.kts
rm -f ../app/build.gradle.kts
mv build.gradle.kts ../app/build.gradle.kts

# create feature modules build gradle files
cat template/data/build.gradle.kts | sed "s/NAME/$NAME/g" > $NAME/data/build.gradle.kts
cat template/domain/build.gradle.kts | sed "s/NAME/$NAME/g" > $NAME/domain/build.gradle.kts
cat template/ui/build.gradle.kts | sed "s/NAME/$NAME/g" > $NAME/ui/build.gradle.kts

# create manifests
echo "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<manifest package=\"$PACKAGE.feature.$NAME.data\" />" > $NAME/data/src/main/AndroidManifest.xml
echo "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<manifest package=\"$PACKAGE.feature.$NAME.domain\" />" > $NAME/domain/src/main/AndroidManifest.xml
echo "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<manifest package=\"$PACKAGE.feature.$NAME.ui\" />" > $NAME/ui/src/main/AndroidManifest.xml

# create git ignores
cp -p template/.gitignore $NAME/data/
cp -p template/.gitignore $NAME/domain/
cp -p template/.gitignore $NAME/ui/