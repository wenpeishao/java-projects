run: SubwayFrontend.class SubwayBackend.class DijkstraPath.class SubwayLoader.class TextUITester.class Station.class Edge.class
	java SubwayFrontend

runTests: runAlgorithmEngineerTests runFrontendDeveloperTests runBackendDeveloperTests runDataWranglerTests

clean:
	rm *.class

# Below are targets that go with run: target

SubwayFrontend.class: SubwayFrontend.java
	javac SubwayFrontend.java

SubwayBackend.class: SubwayBackend.java
	javac SubwayBackend.java

DijkstraPath.class: DijkstraPath.java
	javac DijkstraPath.java

SubwayLoader.class: SubwayLoader.java
	javac SubwayLoader.java

TextUITester.class: TextUITester.java
	javac TextUITester.java

Station.class: Station.java
	javac Station.java

Edge.class: Edge.java
	javac Edge.java


# Below are targets that go with runTests: target

runAlgorithmEngineerTests: AlgorithmEngineerTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=AlgorithmEngineerTests

AlgorithmEngineerTests.class:
	javac -cp .:junit5.jar AlgorithmEngineerTests.java

runFrontendDeveloperTests: FrontendDeveloperTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=FrontendDeveloperTests   

FrontendDeveloperTests.class: FrontendDeveloperTests.java
	javac -cp .:junit5.jar FrontendDeveloperTests.java

runBackendDeveloperTests: BackendDeveloperTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=BackendDeveloperTests

BackendDeveloperTests.class: BackendDeveloperTests.java
	javac -cp .:junit5.jar BackendDeveloperTests.java

runDataWranglerTests: DataWranglerTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java
	javac -cp .:junit5.jar DataWranglerTests.java
