default: runTests

runTests: FrontendDeveloperTestClass.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=FrontendDeveloperTestClass

FrontendDeveloperTestClass.class: FrontendDeveloperTestClass.java
	javac -cp .:junit5.jar FrontendDeveloperTestClass.java

clean:
	rm *.class
