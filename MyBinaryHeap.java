
import java.util.Arrays;
import java.util.Collections;

public class MyBinaryHeap<E extends Comparable<? super E>> {
	private static final int DEFAULT_CAPACITY = 4;
	private int currentSize;
	private E[] heap;
	private int operationCount = 0;

	public int opCount() {
		return operationCount;
	}

	public String toString() {
		String output = "Current Size:" + currentSize + "\n";
		for (int i = 1; i <= currentSize; i++)// heap.length
		{
			//output += i + ":" + ((heap[i] != null) ? heap[i] : "") + "\n";
			/*
			 * same as above output += i+":"; if(heap[i]!=null) output +=
			 * heap[i]; output += "\n";
			 * 
			 */
		}
		return output;
	}

	public MyBinaryHeap() {
		this(DEFAULT_CAPACITY);
	}

	public MyBinaryHeap(int size) {
		currentSize = 0;
		operationCount++;// assignment
		heap = (E[]) new Comparable[size + 1];
		operationCount++;// assignment
	}

	public MyBinaryHeap(E[] items) {
		currentSize = items.length;
		operationCount++;
		// create heap with enough space
		heap = (E[]) new Comparable[nextSize(items.length)];
		operationCount++;
		// put all items into structure out of order
		operationCount++;// assign i value
		operationCount++;// first comparison
		for (int i = 0; i < items.length; i++) {
			heap[i + 1] = items[i];
			operationCount += 2;// addition for array index and assignment

			operationCount++;// comparison
			operationCount++;// increment i
		}
		// fix heap structure
		buildHeap();
	}

	public void NRun() {
		MyBinaryHeap<Integer> h1 = new MyBinaryHeap<>();

		h1.NInsert(10);
		h1.NInsert(25);
		h1.NInsert(50);
		h1.NInsert(100);

	}

	public void NInsert(int n) {
		MyBinaryHeap<Integer> h1 = new MyBinaryHeap<>();
		operationCount++;

		Integer[] b = new Integer[n];
		for (int i = 0; i < b.length; i++){										
			b[i] = i + 1; 
		}				

		System.out.println("\n" + Arrays.toString(b));
		Collections.shuffle(Arrays.asList(b));
		System.out.println(Arrays.toString(b));

		for (Integer I : b) {
			h1.insert(I);
			operationCount++;
		}
		System.out.println("Operation Count:" + h1.opCount());
		operationCount = 0;

	}

	public void bulkRun() {
		MyBinaryHeap<Integer> h1 = new MyBinaryHeap<>();

		h1.bulkInsert(10);
		h1.bulkInsert(25);
		h1.bulkInsert(50);
		h1.bulkInsert(100);

	}

	public void bulkInsert(int n)

	{
		Integer[] c = new Integer[n];
		for (int i = 0; i < n; i++) {
			c[i] = i + 1;
		}

		System.out.println("\n" + Arrays.toString(c));

		Collections.shuffle(Arrays.asList(c));
		operationCount++;

		System.out.println(Arrays.toString(c));

		MyBinaryHeap<Integer> h2 = new MyBinaryHeap<>(c);
		operationCount++;

		System.out.println("Operation Count:" + h2.opCount());

	}

	public void addAll(E[] items) {
		// make room for new items
		if (currentSize + items.length > heap.length)
			growArray(currentSize + items.length);
		// put all items into structure out of order
		for (int i = 0; i < items.length; i++)

			heap[(currentSize + i + 1)] = items[i];
		currentSize += items.length;
		// fix heap structure
		buildHeap();
	}

	public void buildHeap() {
		// start with lowest parent
		for (int i = currentSize / 2; i > 0; i--) {
			percolateDown(i);
			operationCount++;
			operationCount++;
			operationCount += 2;
		}
	}
	
	public boolean isEmpty() {
		operationCount++;
		return (currentSize == 0);
	}
	
	public void makeEmpty() {
		currentSize = 0;
		operationCount++;
	}
	
	private void growArray(int newSize) {
		E[] old = heap;
		operationCount++;

		heap = (E []) new Comparable[newSize];
		for (int i = 1; i <= currentSize; i++) {
			heap[i] = old[i];
			operationCount += 4;
		}
		operationCount++;

	}

	private void growArray() {
		// multiply current length by 2 to allow full level to be added
		this.growArray(heap.length << 1);
		operationCount++;
	}
	
	private int nextSize(int size) {
		operationCount++;

		// finds next size that allows full level to be added
		return 1 << Integer.toBinaryString(size).length();
	}
	
	public void insert(E item) {
		// array is currently full, add next depth
		if (currentSize == heap.length - 1)
			growArray();
		operationCount += 2;

		currentSize++;
		operationCount++;

		int hole = currentSize;
		operationCount++;

		heap[0] = item;// store item in temporary location
		operationCount++;

		percolateUp(hole);
	}

	private void percolateUp(int pos) {
		E item = heap[0];
		operationCount++;

		// check if item is smaller than parent
		// pos/2 = parent, 11 and 10 divided by 2 = 5
		for (; item.compareTo(heap[pos/ 2]) < 0; pos = pos/2)
			heap[pos] = heap[pos/2];

		operationCount += 4;
		//heap[pos] = heap[pos / 2];
		//operationCount++;

		// put item in final position
		heap[pos] = item;
		operationCount++;
	}

	public E deleteMin() {
		if (currentSize == 0)
			return null;
		operationCount++;

		// smallest item
		E temp = heap[1];
		operationCount++;

		// move last item to the root
		heap[1] = heap[currentSize];
		currentSize--;
		operationCount++;
		operationCount++;

		// shift last item down to where it belongs
		percolateDown(1);

		// return smallest item
		return temp;

	}

	private void percolateDown(int pos) {
		int child;
		operationCount++;
		E temp = heap[pos];
		operationCount++;

		// check if there are children
		for (; pos*2 <= currentSize; pos = child) {
			operationCount += 3;

			child = pos * 2;
			operationCount += 2;

			// is there 2 children
			// if there are check if second child is smaller
			if (child != currentSize && heap[child + 1].compareTo(heap[child]) < 0)
				child++;
			operationCount += 2;

			// smaller child compare to parent
			if (heap[child].compareTo(temp) < 0){
				heap[pos] = heap[child];
				operationCount += 3;
			}
			else {
				operationCount++;
				break;
			}
			
			
		}
		heap[pos] = temp;
		operationCount++;

	}

	public E findMin() {
		if (currentSize == 0)
			return null;
		return heap[1];
	}
	

}