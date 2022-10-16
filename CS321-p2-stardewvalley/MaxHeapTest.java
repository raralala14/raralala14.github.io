

public class MaxHeapTest {
	MaxHeap heap = new MaxHeap();

	public static void main(String[] args) throws ClassNotFoundException, HeapException {
		
		MaxHeapTest maxHeapTest = new MaxHeapTest();
		
		maxHeapTest.isEmptyTest();

		Task task1 = new Task(TaskInterface.TaskType.FARM_MAINTENANCE, 1 , 0, "of Harvesting Wheat");
		Task task2 = new Task(TaskInterface.TaskType.FEEDING, 2 , 1, "the Pigs");
		maxHeapTest.insertTest(task1);
		maxHeapTest.insertTest(task2);

		
		maxHeapTest.maxTest();
		maxHeapTest.isEmptyTest();
//		maxHeapTest.increaseKeyTest(task1, 3);
		maxHeapTest.extractMaxTest();
		//maxHeapTest.testTheHeap(task1);
		
		
	}

	private void testTheHeap(Task task) throws HeapException {

		
		Object testArray[] = { task };
		System.out.println("heap extractMax is " + heap.extractMax());
	}

	public void showUsage() {
		System.out.println("java MaxHeapTest ");
		System.exit(1);
	}

	public void heapifyTest() {

	}

	public void maxTest() throws HeapException {
		heap.max();

	}

	public void extractMaxTest() throws HeapException {
		heap.extractMax();
	}

	// insert a series of increasing
	// (or decreasing or random) keys
	// into the heap and then check if
	// the heap was formed properly
	public void insertTest(Task task1) throws HeapException {
		heap.insert(task1);
	}

	public void increaseKeyTest(Task x, int index) throws HeapException {
		// A, x, k
		// if k > x.key
		heap.increasePriorityKey(x, index);
		return;
	}

	public void isEmptyTest() {
		if (heap.isEmpty()) {
			System.out.println(" heap is empty");
		} else {
			System.out.println("heap is NOT empty");
		}
		
	}

}
