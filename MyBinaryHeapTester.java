
public class MyBinaryHeapTester {

	public static void main(String[] args) {

		MyBinaryHeap<String> heap = new MyBinaryHeap<>();
		heap.insert("A");
		heap.insert("H");
		heap.insert("E");
		heap.insert("D");
		heap.insert("B");
		heap.insert("F");
		heap.insert("C");
		heap.insert("G");
		System.out.println(heap);
		//heap.deleteMin();
		//System.out.println(heap);

		MyBinaryHeap<String> heap2 = new MyBinaryHeap<>(new String[]{"A", "H", "E", "D", "B", "F", "C", "G"});
		System.out.println(heap2);
		
		 //insert one at a time
		  System.out.println("\n N insert");
		  MyBinaryHeap<Integer> h1 = new MyBinaryHeap<>();
		  h1.NRun();
		  
		  //insert in bulk and run buildHeap
		  System.out.println("\nBulk Insert");
		  MyBinaryHeap<Integer> h2 = new MyBinaryHeap<>();
		  h2.bulkRun();
	}

}