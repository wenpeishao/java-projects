// --== CS400 Role Code Project Iterator ==--
// Name: Ahmet Ahunbay
// CSL Username: ahunbay
// Email: aaahunbay@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to Grader: N/A
import java.util.ArrayList;
import java.util.Iterator;

public class HouseIterator implements Iterator<House> {
		protected RBTree tree;
		protected House next;
		protected int index =0;
		private Integer min;
		private Integer max;
		protected ArrayList<House> orderedList = new ArrayList<House>();
		
		public HouseIterator(HouseNode root) {
			if(root != null){
				createList(root);
				if(orderedList.size() >0) {
					next = orderedList.get(0);
				}
			}else{
				next = null;
			}
		}
		
		public HouseIterator(HouseNode root, Integer min, Integer max) {
			this.min = min;
			this.max = max;
			if(root != null){
                                createList(root);
                                if(orderedList.size() >0) {
                                        next = orderedList.get(0);
                                }
                        }else{
                                next = null;
                        }
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return next != null;
		}

		@Override
		public House next() {
			House held = next;
			if(index+1<orderedList.size()) {
				
				index ++;
				next =orderedList.get(index);
				return held;
				
			} else {
				next = null;
			}
			return held;
			
		}
		
		private void createList(HouseNode nodeAdd) {
			if(min == null || min <= nodeAdd.data.getPrice()) {
				if(nodeAdd.leftChild != null) {
		
					createList(nodeAdd.leftChild);
				
				}
			if (max == null || max>= nodeAdd.data.getPrice()) {
				orderedList.add(nodeAdd.data);
			}
			}
			
			if(nodeAdd.rightChild != null) {
			
				createList(nodeAdd.rightChild);
			}
		}

	}
