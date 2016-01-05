#!/bin/sh

clear

echo "Removing Unneeded Files"
rm -r infoParser/appData
rmdir infoParser/appData
rm images/*
rm images/screenshots/*
rm text/*.txt

