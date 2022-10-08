import java.lang.reflect.Array;

public class MaxHeap  {

	
	private int[] Heap;
	private int size;
	private int maxsize;

	/**
	 * 
	 */
	public MaxHeap() {
		extractMax();
	}

	/**
	 * 
	 * @param heapArray
	 */
	public MaxHeap(Object task) {
		this.maxsize = size;
		this.size = 0;
		Heap = new int[this.maxsize +1];
		Heap[0] = Integer.MAX_VALUE;
		//buildMaxHeap(Heap);
	}

	/**
	 * 
	 * @param heapArray
	 */
	private void buildMaxHeap(Object[] heapArray) {

	}

	/**
	 * 
	 */
	public void heapify() {

	}

	/**
	 * return largest key
	 */
	public void max() {

	}

	/**
	 * select the highest job among those pending
	 */
	public void extractMax() {
		// root is always max so grab root
		//
		//System.out.println(Heap[0]);
		System.out.println("yay");
	}

	/**
	 * add new job to the queue
	 * 
	 * @param task
	 */
	public void insert(Task taskToInsert) {
		//System.out.println(Heap.length);
		System.out.println("Insert " + taskToInsert.getPriority());
		int heapLength = Heap.length;
		//Heap[heapLength - 1] = taskToInsert;
		System.out.println(Heap.length);
		
	}
	// hello

	public void increaseKey() {

	}

	public boolean isEmpty() {
		return false;

	}

}
