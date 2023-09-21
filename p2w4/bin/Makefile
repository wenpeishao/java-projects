runTests: AlgorithmEngineerTests.class FrontendDeveloperTests.class BackendDeveloperTests.class DataWranglerTests.class
	 java -jar junit5.jar --class-path=. --include-classname=.* --select-class=DataWranglerTests
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=AlgorithmEngineerTests
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=BackendDeveloperTests
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=FrontendDeveloperTests

run: IHouseSearcherBackend.class IHouseSearcherFrontend.class SortedCollectionInterface.class TextUITester.class HouseADT.class IRBTree.class House.class  HouseNode.class HouseSearcherBackend.class HouseSearcherFrontend.class RBTree.class HouseLoader.class
	java HouseSearcherFrontend

clean:
	rm *.class
HouseLoader.class: 
	javac HouseLoader.java
IHouseSearcherBackend.class:
	javac IHouseSearcherBackend.java

HouseSearcherBackend.class:
	javac HouseSearcherBackend.java

IHouseSearcherFrontend.class:
	javac IHouseSearcherFrontend.java

HouseSearcherFrontend.class:
	javac HouseSearcherFrontend.java

SortedCollectionInterface.class:
	javac SortedCollectionInterface.java

TextUITester.class:
	javac TextUITester.java

HouseADT.class:
	javac HouseADT.java

House.class:
	javac House.java

HouseIterator.class:
	javac HouseIterator.java

HouseNode.class:
	javac HouseNode.java

IRBTree.class:
	javac IRBTree.java

RBTree.class:
	javac RBTree.java

runAlgrorithmEngineerTests: AlgorithmEngineerTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=AlgorithmEngineerTests

AlgorithmEngineerTests.class: AlgorithmEngineerTests.java
	javac -cp .:junit5.jar AlgorithmEngineerTests.java

runBackendTests: BackendDeveloperTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=BackendDeveloperTests

BackendDeveloperTests.class: BackendDeveloperTests.java
	javac -cp .:junit5.jar BackendDeveloperTests.java

DataWranglerTests.class: DataWranglerTests.java
	javac -cp .:junit5.jar DataWranglerTests.java

default: runTests

runFrontendDeveloperTests: FrontendDeveloperTests.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=FrontendDeveloperTests

FrontendDeveloperTests.class: FrontendDeveloperTests.java
	javac -cp .:junit5.jar FrontendDeveloperTests.java
