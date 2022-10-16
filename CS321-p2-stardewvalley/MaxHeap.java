import java.lang.reflect.Array;
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

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	private int parent(int i) {
		return ((i - 1) / 2);
	}

	/**
	 * 
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
	public Task max()  {

		if (isEmpty()) {
			System.out.println("heap is empty");
		}

		else {
			Task maxTask = heap[1];
			return maxTask;

		}
		return null;

	}

	/**
	 * takes out element from root and takes out
	 * the last element from the last level from
	 * he heap and replaces the root with the 
	 * element
	 * @throws HeapException 
	 */
	public Task extractMax()  {
		Task max = max();
		heap[1] = heap[heapSize];
		heapSize = heapSize - 1;
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
		
		System.out.println("Current heapSize prior to insert: " + heapSize);
		System.out.println("Inserting with priority = " + taskToInsert.getPriority());
		heapSize++;	
		if (heapSize == DEFAULT_SIZE) {
			System.out.println("heapSize is greater or equal to DEFAULT_SIZE");
			heap = Arrays.copyOf(heap, heap.length*2);
		}
		

		int k = taskToInsert.getPriority();
		heap[heapSize] = taskToInsert;
		increasePriorityKey(taskToInsert, k);
		System.out.println("heap size is now " + heapSize);
		
		
		
		
//		System.out.println("heap size is now " + heapSize);
//		heap[heapSize] = taskToInsert;
//		increaseKey(taskToInsert, heapSize);
		System.out.println("Inserted priority is now: " + heap[heapSize].getPriority());
		

		System.out.println("New heapSize after insert: " + heapSize);

	}
	

	/**
	 * Increases the value of x.priorityLevel with index Assumed to be =>
	 * x.priorityLevel
	 * 
	 * @param x The task to increase priority
	 * @param newPriority The new priority for the task
	 * @throws HeapException
	 */
	public void increasePriorityKey(Task x, int newPriority) throws HeapException {
		System.out.println("increasePriorityKey(newPriority) = " + newPriority);
		System.out.println("increasePriorityKey(x.getDescription()) " + x.getTaskDescription());
		
		int i = 1;
		int index = 1;
        while(i < heap.length) {
            if(heap[i] == x) {
                index = i;
                break;
            }
            i++;
        }
        System.out.println("index is " + index);
        System.out.println("this is the parents index " + this.parent(index));
//        while(index > 1 && heap[this.parent(index)].getPriority() < heap[index].getPriority()) {
//        	
//        }
       
		if (index > 1) {
			if (x.compareTo(heap[this.parent(index)]) < 0) {
				throw new HeapException("new key is smaller so not valid ");
			} else {
				x.setPriority(newPriority);

			}

		}
       
//		int index = heap.
//		int a = 1;
//		int b = 2;
//		int temp = 3;
//		
//		temp = a;
//		a = b; 
//		b = temp;
		
		
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
