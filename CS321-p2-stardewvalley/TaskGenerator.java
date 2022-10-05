
public class TaskGenerator implements TaskGeneratorInterface {
	
	
	int currentEnergyStorage = 0;
	int probability;
	int randomSeed;
	
	public TaskGenerator (double taskGenerationProbability) {
	
	}
	
	
	public TaskGenerator (double taskGenerationProbability, long seed) {
		
	}
	
	
	@Override
	public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void decrementEnergyStorage(TaskInterface.TaskType taskType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetCurrentEnergyStorage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCurrentEnergyStorage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCurrentEnergyStorage(int newEnergyNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean generateTask() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUnlucky(Task task, double unluckyProbability) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Create a String containing the Task's information.
	 *
	 * @param task - the Task
	 * @param taskType - the Task's type
	 */
	@Override
	public String toString(Task task, Task.TaskType taskType) {
	        if(taskType == Task.TaskType.MINING) {
	            return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
	        }
	        if(taskType == Task.TaskType.FISHING) {
	            return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
	        }
	        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
	            return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
	        }
	        if(taskType == Task.TaskType.FORAGING) {
	            return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
	        }
	        if(taskType == Task.TaskType.FEEDING) {
	            return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
	        }
	        if(taskType == Task.TaskType.SOCIALIZING) {
	            return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
	        }
	        else { return "nothing to see here..."; }
	}


}
