import java.util.Arrays;

public class MaxHeap {

	private int DEFAULT_SIZE = 10;

	protected Task[] heap;
	protected int heapSize;

	/**
	 * 
	 */
	public MaxHeap() {
		heap = new Task[DEFAULT_SIZE];
		heapSize = 0;
	}

	/**
	 * 
	 * @param i
	 * @return integer left child
	 */
	private int left(int i) {
		return 2 * i + 1;
	}

	/**
	 * 
	 * @param i
	 * @return integer right child
	 */
	private int right(int i) {
		return 2 * i + 2;
	}

	/**
	 * 
	 * @param i
	 * @return integer parent
	 */
	private int parent(int i) {
		return ((i - 1) / 2);
	}

	/**
	 * Sort the heap
	 * 
	 * @param index
	 */
	public void heapify(int index) {
		int l = left(index);
		int r = right(index);
		int largest = index;

		if ((l < heapSize) && (heap[l].compareTo(heap[index]) > 0)) {
			largest = l;
		}
		if ((r < heapSize) && (heap[r].compareTo(heap[largest]) > 0)) {
			largest = r;
		}
		if (largest != index) {
			Task tmp = heap[largest];
			heap[largest] = heap[index];
			heap[index] = tmp;
			heapify(largest);
		}

	}

	/**
	 * return largest key
	 * 
	 * @throws HeapException
	 */
	public Task max() {

		if (isEmpty()) {
			return null;
		} else {
			return heap[1];
		}

	}

	/**
	 * takes out element from root and takes out the last element from the last
	 * level from he heap and replaces the root with the element
	 */
	public Task extractMax() {
		Task max = max();
		heap[1] = heap[heapSize];
		heapSize--;
		heapify(1);
		return max;

	}

	/**
	 * add new job to the queue
	 * 
	 * @param task
	 * @throws HeapException
	 */
	public void insert(Task taskToInsert) throws HeapException {	
		heapSize++;
		if (heapSize == DEFAULT_SIZE) {
			doubleTheHeap();
		}

		int taskPriority = taskToInsert.getPriority();
		heap[heapSize] = taskToInsert;

		increasePriorityKey(taskToInsert, taskPriority);

	}

	/**
	 * doubles the heap
	 */
	private void doubleTheHeap() {

		heap = Arrays.copyOf(heap, heap.length * 2);
	}

	/**
	 * Increases the value of x.priorityLevel with newPriority Assumed to be =>
	 * x.priorityLevel
	 * 
	 * @param x           The task to increase priority
	 * @param newPriority The new priority for the task
	 * @throws HeapException
	 */
	public void increasePriorityKey(Task x, int newPriority) throws HeapException {

		int i = 1;
		int index = 1;
		while (i < heapSize) {
			if (heap[i] == x) {
				index = i;
				break;
			}
			i++;
		}

		while (index > 1 && heap[this.parent(index)].getPriority() < heap[index].getPriority()) {
			Task tmpTask = heap[index];
			Task tmpParentTask = heap[this.parent(index)];
			heap[index] = tmpParentTask;
			heap[this.parent(index)] = tmpTask;
		}

		index = this.parent(index);

		if (index > 1) {
			if (x.compareTo(heap[this.parent(index)]) < 0) {
				throw new HeapException("new key is smaller so not valid ");
			} else {
				x.setPriority(newPriority);

			}

		}

	}

	/**
	 * Method that returns true when heap is empty, otherwise false
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (heapSize == 0) {
			return true;
		}
		return false;

	}

}
