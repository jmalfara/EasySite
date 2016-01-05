all: ParseForName.class ImageGet.class GetInfo.class GetVersion.class ColorAverage.class
	
ParseForName.class: ParseForName.java
	javac ParseForName.java

ImageGet.class: ImageGet.java
	javac -cp "jsoup-1.8.1.jar:image4j.jar" ImageGet.java

GetInfo.class: GetInfo.java
	javac -cp jsoup-1.8.1.jar GetInfo.java

GetVersion.class: GetVersion.java
	javac -cp jsoup-1.8.1.jar GetVersion.java

ColorAverage.class: ColorAverage.java
	javac ColorAverage.java

clean:
	rm ParseForName.class GetInfo.class ImageGet.class GetVersion.class ColorAverage.class
