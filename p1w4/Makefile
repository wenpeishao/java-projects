
# run the tests
runTests: AlgorithmEngineerTest.class FrontendDeveloperTest.class BackendDeveloperTest.class BookLoaderTester.class
	java FrontendDeveloperTest
	java AlgorithmEngineerTest
	java BackendDeveloperTest
	java BookLoaderTester

# These compile the test classes
BackendDeveloperTest.class: BackendDeveloperTest.java
	javac BackendDeveloperTest.java
FrontendDeveloperTest.class: FrontendDeveloperTest.java
	javac FrontendDeveloperTest.java
BookLoaderTester.class: BookLoaderTester.java
	javac BookLoaderTester.java
AlgorithmEngineerTest.class: AlgorithmEngineerTest.java
	javac AlgorithmEngineerTest.java
TextUITester.class:
	javac TextUITester.java


# These compile the .java classes for the actual code
Book.class: Book.java
	javac Book.java
BookLoader.class: BookLoader.java
	javac BookLoader.java	
BookMapper.class: BookMapper.java
	javac BookMapper.java
BookMapperBackend.class: BookMapperBackend.java
	javac BookMapperBackend.java
BookMapperFrontend.class: BookMapperFrontend.java
	javac BookMapperFrontend.java
HashIterator.class: HashIterator.java
	javac HashIterator.java
HashtableMap.class: HashtableMap.java
	javac HashtableMap.java
IISBNVal.class: IISBNVal.java
	javac IISBNVal.java
IterableHashtable.class: IterableHashtable.java
	javac IterableHashtable.java
IterableMapADT.class: IterableMapADT.java
	javac IterableMapADT.java
MapADT.class: MapADT.java
	javac MapADT.java
IBook.class: IBook.java
	javac IBook.java
IBookLoader.class: IBookLoader.java
	javac IBookLoader.java
IBookMapperBackend.class: IBookMapperBackend.java
	javac IBookMapperBackend.java
IBookMapperFrontend.class: IBookMapperFrontend.java
	javac IBookMapperFrontend.java
IISBNValidator.class: IISBNValidator.java
	javac IISBNValidator.java
	


# run the actual code
run: IBook.class IBookLoader.class IBookMapperBackend.class IBookMapperFrontend.class IISBNValidator.class MapADT.class BookMapper.class Book.class BookLoader.class BookMapperBackend.class BookMapperFrontend.class IterableMapADT.class IterableHashtable.class IISBNVal.class 
	java BookMapper

clean:
	rm *.class
