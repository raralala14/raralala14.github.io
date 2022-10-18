
public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface  {

	int waitingTime;
	/**
     * Adds a task to the rear of the list.
     * via MaxHeap insert()
     *
     * @param task - Task to enqueue
     */
	
	public MyPriorityQueue () {
		super();
	}
//	public MyPriorityQueue (Task [] queue) {
//		super(queue);
//	}

	public void enqueue(Object task) {

		try {
			super.insert((Task) task);

		} catch (HeapException e) {
			e.printStackTrace();
		}

	}

	@Override
	 /**
     * Removes the front element from the list.
     * via MaxHeap ExtractMax()
     *
     * @return first element in the Task array 
     */
		public Task dequeue() {

			if (!isEmpty()) {
			
				return super.extractMax();

			} else {

				return null;
			}

			
		}
	/**
     * Boolean for if the max-heap is empty.
     *
     * @return true or false - depending on if the Heap is empty
     */
    public boolean isEmpty() {
    	
    	if (heapSize == 0) {
			return true;
		}
		return false;
	}
    
	@Override
	 /**
     * Increase the priorities for a given task in the queue if it has waited enough 
     * time but not to exceed its maximum priority.
     *
     * @param timeToIncrementPriority how long it should have waited for
     * @param maxPriority  the maximum priority value the task can have
     */
	public void update(int timeToIncrementPriority, int maxPriority) {
		
		waitingTime++;
		if (waitingTime >= timeToIncrementPriority) {
			waitingTime = 0;
			if (super.heapSize < maxPriority);
		}
		
	}

	
}
