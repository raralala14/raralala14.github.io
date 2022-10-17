

public class MaxHeapTest {
	MaxHeap heap = new MaxHeap();

	public static void main(String[] args) throws ClassNotFoundException, HeapException {
		
		MaxHeapTest maxHeapTest = new MaxHeapTest();
		maxHeapTest.testMaxHeap();
		
		System.out.println("running isEmptyTest on an empty heap");
		maxHeapTest.isEmptyTest();

		
		Task task1 = new Task(TaskInterface.TaskType.FARM_MAINTENANCE, 1 , 0, "of Harvesting Wheat");
		Task task2 = new Task(TaskInterface.TaskType.FEEDING, 2 , 1, "the Pigs");
		maxHeapTest.insertTest(task1);
		maxHeapTest.insertTest(task2);

		
		maxHeapTest.maxTest();
		maxHeapTest.isNotEmptyTest();
//		maxHeapTest.increaseKeyTest(task1, 3);
		maxHeapTest.extractMaxTest();
		maxHeapTest.testTheHeap(task1);
		
		
	}



	private void testMaxHeap() {
		if(heap.heapSize > 0) {
			System.out.println("PROBLEM: new heap should be 0 size");
		}
		
	}



	private void testTheHeap(Task task) throws HeapException {

		
		//Object testArray[] = { task };
		System.out.println("heap extractMax is " + heap.extractMax());
	}

	public void showUsage() {
		System.out.println("java MaxHeapTest ");
		System.exit(1);
	}

	public void heapifyTest() {

	}

	public void maxTest() throws HeapException {
		System.out.println("running maxTest()");
		heap.max();

	}

	public void extractMaxTest() throws HeapException {
		heap.extractMax();
	}

	// insert a series of increasing
	// (or decreasing or random) keys
	// into the heap and then check if
	// the heap was formed properly
	public void insertTest(Task task) throws HeapException {
//		System.out.println("Called MaxHeapTest.insertTest()");
		heap.insert(task);
	}

	public void increaseKeyTest(Task x, int index) throws HeapException {
		// A, x, k
		// if k > x.key
		heap.increasePriorityKey(x, index);
		return;
	}

	/**
	 */
	public void isEmptyTest() {
		System.out.println("The heap size is: " + heap.heapSize);
		// if notEmpty is true then we are testing to make sure the 
		// heap is empty and heapSize is also empty
		
		if (heap.isEmpty() && heap.heapSize > 0) {
			System.out.println("PROBLEM: heap should be empty but isEmpty is not");
		}
	}

	private void isNotEmptyTest() {
		System.out.println("The heap size is: " + heap.heapSize);
		if (!heap.isEmpty() && heap.heapSize == 0) {
			System.out.println("PROBLEM: heap should NOT be empty but isEmpty is returning true");
		}
	}
}
