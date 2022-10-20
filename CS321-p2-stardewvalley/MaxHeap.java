import java.util.Arrays;

public class MaxHeap {

	private int DEFAULT_SIZE = 10;

	protected Task[] heap;
	protected int heapSize;

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
		return (2 * i);
	}

	/**
	 * 
	 * @param i
	 * @return integer right child
	 */
	private int right(int i) {
		return (2 * i) + 1;
	}

	/**
	 * 
	 * @param i
	 * @return integer parent
	 */
	private int parent(int i) {
		return (int) Math.floor(i / 2);
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

		if ((l <= heapSize) && (heap[l].compareTo(heap[index]) > 0)) {
			largest = l;
		}
		if ((r <= heapSize) && (heap[r].compareTo(heap[largest]) > 0)) {
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
		if (heapSize == heap.length - 1) {
			doubleTheHeap();
		}
		heap[heapSize] = taskToInsert;

		heapifyUp(heapSize);

	}
	/**
	 * 
	 * @param index
	 */
	public void heapifyUp(int index) {
		if (heapSize == 1) {
			return;
		}
		if (index <= heapSize && index > 1)
			if (heap[parent(index)].compareTo(heap[index]) == -1) {
				Task tmp = heap[parent(index)];
				heap[parent(index)] = heap[index];
				heap[index] = tmp;
				heapifyUp(parent(index));
			}
	}

	/**
	 * doubles the heap
	 */
	private void doubleTheHeap() {

		heap = Arrays.copyOf(heap, heap.length * 2);
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