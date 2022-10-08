import java.lang.reflect.Array;

public class MaxHeapTest {
	MaxHeap heap = new MaxHeap();

	public static void main(String[] args) throws ClassNotFoundException {
		

		Task task1 = new Task();
		task1.setPriority(0);
		MaxHeapTest maxHeapTest = new MaxHeapTest();

		//maxHeapTest.testTheHeap();
		//maxHeapTest.insertTest(task1);
	}

	private void testTheHeap(Task task) {

		
		Object testArray[] = { task };

		MaxHeap heap = new MaxHeap(testArray);
		System.out.println(testArray.toString());

	}

	public void showUsage() {
		System.out.println("java MaxHeapTest ");
		System.exit(1);
	}

	public void heapifyTest() {

	}

	public void maxTest() {

	}

	public void extractMaxTest() {

	}

	// insert a series of increasing
	// (or decreasing or random) keys
	// into the heap and then check if
	// the heap was formed properly
	public void insertTest(Task task1) {
		//heap.insert(task1);
	}

	public void increaseKeyTest() {

	}

	public void isEmptyTest() {

	}

}
