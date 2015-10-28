default: build

.PHONY: build

clean:
	gradle clean

build:
	gradle build

install:
	gradle installDebug

pkg: package
package:
	zip -r Midterm_KalevKaldaSikes_100425828.zip \
		app gradle originals res \
		src tool build gen \
		build.gradle \
		gradlew.bat \
		makefile \
		gradlew \
		local.properties \
		midterm.iml \
		settings.gradle \
		test.sh

icons:
	tool/gen_icons.sh
	cp gen/icon_48x48.png \
		app/src/main/res/drawable-mdpi/ic_launcher.png
	cp gen/icon_72x72.png \
		app/src/main/res/drawable-hdpi/ic_launcher.png
	cp gen/icon_96x96.png \
		app/src/main/res/drawable-xhdpi/ic_launcher.png
	cp gen/icon_144x144.png \
		app/src/main/res/drawable-xxhdpi/ic_launcher.png
