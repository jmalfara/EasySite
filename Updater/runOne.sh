#!/bin/sh

update () {
	clear

	NAME=$(ls $1*.apk)
	echo "$NAME"

	java -jar infoParser/apktool.jar d $NAME -f -s -b -o 'infoParser/appData'

	echo "Compile ALL"
	cd infoParser
	make

	echo "Finding NameUrl"
	java ParseForName

	echo "Running GetInfo"
	java -cp .:jsoup-1.8.1.jar GetInfo "$1"

	echo "Running GetImage"
	java -cp .:jsoup-1.8.1.jar:image4j.jar ImageGet

	echo "Running GetVersion"
	java -cp .:jsoup-1.8.1.jar GetVersion

	echo "Running ColorAverage"
	java ColorAverage

	echo "Finishing Up. Moving Images"
	rm ../$1images/*.*
	rm ../$1images/screenshots/*.*
	cp -r ../images/* "../$1images/"

	echo "Moving Texts"
	cp -r ../text/* "../$1text/"
	echo "Creating Date Modified"
	rm "../$1text/DateMod.txt"
	echo "$(date)" >> "../$1text/DateMod.txt"

	echo "Removing Unneeded Files"
	rm -r appData
	rm ../images/*
	rm ../images/screenshots/*
	rm ../text/*.txt
	cd ..
}

clear

read wanted;

for dir in ../*/
do
    echo "$dir"
    if [ "$dir" = "../$wanted/" ]
    then
    	update $dir
	echo "Good"
    fi
done


