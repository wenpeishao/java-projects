// --== CS400 Role Code Project Testers ==--
// Name: Ahmet Ahunbay
// CSL Username: ahunbay
// Email: aaahunbay@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to Grader: N/A

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlgorithmEngineerTests {
	RBTree<House> test = null;
	
	@BeforeEach
    public void createInstance() {
    	test = new RBTree();
    }
	

    
	/**
     * Tests basic null(black) aunt rotation/recolor, tests basic black aunt response with extra rotation for alignment,
     * tests red aunt recolor to black aunt rotation/recolor
     */
    @Test
	public void test1() {
    	test.insert(new House(10,10,10));
    	test.insert(new House(20,10,10));
    	test.insert(new House(30,10,10));
    	
    	//results from basic rotation x recolor
    	//color tests
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 0);
    	assertEquals(test.root.rightChild.blackHeight, 0);
    	//data tests

    	assertEquals(test.root.data.compareTo(new House(20,10,10)), 0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(10,10,10)), 0);
    	assertEquals(test.root.rightChild.data.compareTo(new House(30,10,10)), 0);
    	
    	//red aunt recolor operation
    	test.insert(new House(40,10,10));
    	test.insert(new House(35,10,10));
    	
    	//results from black aunt response with extra rotation for alignment
    	//color tests
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.rightChild.blackHeight, 0);
    	assertEquals(test.root.rightChild.leftChild.blackHeight, 0);
    	//data tests
    	assertEquals(test.root.data.compareTo(new House(20,10,10)), 0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(10,10,10)), 0);
    	assertEquals(test.root.rightChild.data.compareTo(new House(35,10,10)), 0);
    	assertEquals(test.root.rightChild.leftChild.data.compareTo(new House(30,10,10)),0);
    	assertEquals(test.root.rightChild.rightChild.data.compareTo(new House(40,10,10)),0);
    	
    	//red aunt recolor op
    	test.insert(new House(45,10,10));
    	test.insert(new House(38,10,10));
    	//red aunt recolor to black aunt rotation/recolor
    	test.insert(new House(37,10,10));
    	
    	//results from red aunt recolor to black aunt rotation/recolor
    	//color tests
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 0);
    	assertEquals(test.root.rightChild.blackHeight, 0);
    	assertEquals(test.root.rightChild.rightChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.leftChild.blackHeight, 1);
    	assertEquals(test.root.leftChild.leftChild.blackHeight, 1);
    	assertEquals(test.root.leftChild.rightChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.leftChild.leftChild.blackHeight, 0);
    	//data tests
    	assertEquals(test.root.data.compareTo(new House(35,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(20,10,10)),0);
    	assertEquals(test.root.rightChild.data.compareTo(new House(40,10,10)),0);
    	assertEquals(test.root.rightChild.rightChild.data.compareTo(new House(45,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.data.compareTo(new House(38,10,10)),0);
    	assertEquals(test.root.leftChild.leftChild.data.compareTo(new House(10,10,10)),0);
    	assertEquals(test.root.leftChild.rightChild.data.compareTo(new House(30,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.leftChild.data.compareTo(new House(37,10,10)),0);
    	 	
	}   
    
    /**
     * Tests basic red leaf removal and black node with red replacement
     */
    @Test
    public void test2() {
    	test.insert(new House(20,10,10));
    	test.insert(new House(10,10,10));
    	test.insert(new House(30,10,10));
    	
    	//removes red leaf
    	test.remove(new House(30,10,10));
    	
    	//checks state
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 0);
    	assertEquals(test.root.data.compareTo(new House(20,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(10,10,10)),0);
    	assertEquals(test.size, 2);
    	
    	test.insert(new House(30,10,10));
    	//removes black node with red replacement
    	test.remove(new House(20,10,10));
    	
    	//checks state
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 0);
    	assertEquals(test.root.rightChild, null);
    	assertEquals(test.root.data.compareTo(new House(30,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(10,10,10)),0);
    	assertEquals(test.size, 2);
    }

    /**
     * tests an instance all repair operations 
     */
    @Test
    public void test3() {
    	test.insert(new House(20,10,10));
    	test.insert(new House(10,10,10));
    	test.insert(new House(30,10,10));
    	test.insert(new House(40,10,10));
    	test.insert(new House(50,10,10));
    	test.insert(new House(60,10,10));
    	test.remove(new House(60,10,10));
    	
    	//checks state in preparation
    	assertEquals(test.root.data.compareTo(new House(20,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(10,10,10)),0);
    	assertEquals(test.root.leftChild.leftChild, null);
    	assertEquals(test.root.leftChild.rightChild, null);
    	assertEquals(test.root.rightChild.data.compareTo(new House(40,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.data.compareTo(new House(30,10,10)),0);
    	assertEquals(test.root.rightChild.rightChild.data.compareTo(new House(50,10,10)),0);

    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.blackHeight, 0);
    	assertEquals(test.root.rightChild.leftChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.rightChild.blackHeight, 1);
    	
    	//tests bottom two repair operations(on document)
    	test.remove(new House(10,10,10));
    	
    	assertEquals(test.root.data.compareTo(new House(40,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(20,10,10)),0);
    	assertEquals(test.root.rightChild.data.compareTo(new House(50,10,10)),0);
    	assertEquals(test.root.leftChild.rightChild.data.compareTo(new House(30,10,10)),0);
    	
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.blackHeight, 1);
    	assertEquals(test.root.leftChild.rightChild.blackHeight, 0);
    	
    	//tests top two repair operations(on document)
    	test.remove(new House(50,10,10));
    	assertEquals(test.root.data.compareTo(new House(30,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(20,10,10)),0);
    	assertEquals(test.root.rightChild.data.compareTo(new House(40,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild, null);
    	assertEquals(test.root.rightChild.rightChild, null);
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.blackHeight, 1);
    	
    	//makes preparations and checks state of tree
    	test.insert(new House(45,10,10));
    	test.insert(new House(50,10,10));
    	test.insert(new House(55,10,10));
    	test.insert(new House(35,10,10));
    	
    	assertEquals(test.root.data.compareTo(new House(30,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(20,10,10)),0);
    	assertEquals(test.root.rightChild.data.compareTo(new House(45,10,10)),0);
    	assertEquals(test.root.rightChild.rightChild.data.compareTo(new House(50,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.data.compareTo(new House(40,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.leftChild.data.compareTo(new House(35,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.leftChild.rightChild, null);
    	assertEquals(test.root.rightChild.leftChild.leftChild.leftChild, null);
    	assertEquals(test.root.rightChild.rightChild.rightChild.data.compareTo(new House(55,10,10)),0);
    	assertEquals(test.root.rightChild.rightChild.rightChild.leftChild,null);
    	assertEquals(test.root.rightChild.rightChild.rightChild.rightChild,null);
    	
    	
    	//replaces red node with black node
    	test.remove(new House(45,10,10));
    	
    	assertEquals(test.root.data.compareTo(new House(30,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(20,10,10)),0);
    	assertEquals(test.root.rightChild.data.compareTo(new House(50,10,10)),0);
    	assertEquals(test.root.rightChild.rightChild.data.compareTo(new House(55,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.data.compareTo(new House(40,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.leftChild.data.compareTo(new House(35,10,10)),0);

    	
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.blackHeight, 0);
    	assertEquals(test.root.rightChild.rightChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.leftChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.leftChild.leftChild.blackHeight, 0);
    	
    	//replaces black node with deep red node
    	test.remove(new House(30,10,10));

    	assertEquals(test.root.data.compareTo(new House(35,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(20,10,10)),0);
    	assertEquals(test.root.rightChild.data.compareTo(new House(50,10,10)),0);
    	assertEquals(test.root.rightChild.rightChild.data.compareTo(new House(55,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.data.compareTo(new House(40,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.leftChild, null);
    	assertEquals(test.root.rightChild.leftChild.rightChild, null);
    	
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.blackHeight, 0);
    	assertEquals(test.root.rightChild.rightChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.leftChild.blackHeight, 1);
    	
    	
    	test.insert(new House(45,10,10));
    	
    	//replaces black node with deep black node
    	test.remove(new House(35,10,10));
    	

    	assertEquals(test.root.data.compareTo(new House(40,10,10)),0);
    	assertEquals(test.root.leftChild.data.compareTo(new House(20,10,10)),0);
    	assertEquals(test.root.leftChild.leftChild, null);
    	assertEquals(test.root.leftChild.rightChild, null);
    	assertEquals(test.root.rightChild.data.compareTo(new House(50,10,10)),0);
    	assertEquals(test.root.rightChild.rightChild.data.compareTo(new House(55,10,10)),0);
    	assertEquals(test.root.rightChild.rightChild.rightChild, null);
    	assertEquals(test.root.rightChild.rightChild.leftChild, null);
    	assertEquals(test.root.rightChild.leftChild.data.compareTo(new House(45,10,10)),0);
    	assertEquals(test.root.rightChild.leftChild.rightChild, null);
    	assertEquals(test.root.rightChild.leftChild.leftChild, null);
    	
    	assertEquals(test.root.blackHeight, 1);
    	assertEquals(test.root.leftChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.blackHeight, 0);
    	assertEquals(test.root.rightChild.rightChild.blackHeight, 1);
    	assertEquals(test.root.rightChild.leftChild.blackHeight, 1);
    	
    }
    /**
     * tests size method and isEmpty
     */
    @Test
    public void test4() {
    	assertTrue(test.isEmpty());
    	//tests size up to 100 nodes
    	for(int i =0; i<100; i++) {
    		assertEquals(test.size(), i );
    		test.insert(new House(i,i,i));
    		assertFalse(test.isEmpty());
    	}
	
    }
    
    /**
     * tests the iterator in the HouseRBTree
     */
    @Test
    public void test5() {    	
    	for(int i =0; i<100; i++) { 
    		test.insert(new House(i,i,i));
    	}

    	//tests basic iterator through 100 nodes
    	Iterator testIterator = test.iterator();
    	ArrayList<House> houseList = new ArrayList<House>();
    	for(Object a: test) {
    		houseList.add((House)a); 		
    	}
    	for(int i = 0; i<100;i++) {
    		assertEquals(i,houseList.get(i).getPrice());		
    	} 	
    	
    	//tests iterateAtRange with null parameters
    	Iterator nullIterator = test.iterateAtRange(null,null);
    	
    	houseList.clear();
    	while(nullIterator.hasNext()) {
    		houseList.add((House) nullIterator.next());
    	}
    	for(int i = 0; i<100;i++) {
    		assertEquals(i,houseList.get(i).getPrice());		
    	}
    	
    	//tests with min 25 and max 50
    	nullIterator = test.iterateAtRange(25,50);
    	houseList.clear();
    	while(nullIterator.hasNext()) {
    		houseList.add((House) nullIterator.next());
    	}
    	for(int i = 25; i<51;i++) {
    		assertEquals(i,houseList.get(i-25).getPrice());		
    	}
    	
    	
    	//tests with min 25 and null max
    	nullIterator = test.iterateAtRange(25,null);
    	houseList.clear();
    	while(nullIterator.hasNext()) {
    		houseList.add((House) nullIterator.next());
    	}
    	for(int i = 25; i<100;i++) {
    		assertEquals(i,houseList.get(i-25).getPrice());		
    	}
    	
    	//tests with null min, 50 max
    	nullIterator = test.iterateAtRange(null,50);
    	houseList.clear();
    	while(nullIterator.hasNext()) {
    		houseList.add((House) nullIterator.next());
    	}
    	for(int i = 0; i<51;i++) {
    		assertEquals(i,houseList.get(i).getPrice());		
    	}
    }

    @Test
    public void CodeReviewOfFrontendDeveloper1(){
	
    }

    @Test
    public void CodeReviewOfFrontendDeveloper2(){

    }
}

