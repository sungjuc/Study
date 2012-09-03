package lab.l04;

class QuickSort extends Sort {
	/*
	 * You should implement this. It is the meat of the constructor and is also
	 * used by the reset() method.
	 * 
	 * It will create the QuickSort object with an "unsorted" list.
	 * 
	 * - how_many is the number of elements in the list. - workload_type is
	 * BEST_CASE, WORST_CASE, or AVG_CASE
	 */

	protected void init(int how_many, int workload_type) {
		/*
		 * Insert your code here
		 * 
		 * IMPORTANT NOTE: You need to allocate the numbers array declared in
		 * the sort class so that it can hold "how_many" numbers, and you need
		 * to fill numbers (integers) into this array. The ordering should be
		 * determined by the workload.
		 * 
		 * Since you may be using the same workload for many different sorts and
		 * configurations of the same sort, you might want to use helper
		 * methods. Helper methods that should be accessible to all of the sorts
		 * should be "protected (not public or private) and placed in the Sort
		 * class. Helper methods used by only this sort can stay in this file
		 * and be made "private".
		 * 
		 * This method should NOT sort the array.
		 */
		numbers = new int[how_many];

		switch (workload_type) {
		case 1:
			createBestCase(how_many);
			break;
		case 2:
			createAverageCase(how_many);
			break;
		case 3:
			createWorstCase(how_many);
			break;
		}
	}

	/*
	 * This is the constructor. It is nothing more than a shell to call init().
	 * This allows init() to be used by both the constructor and also the parent
	 * class's reset() method
	 */
	public QuickSort(int how_many, int workload_type) {
		this.how_many = how_many;
		this.workload_type = workload_type;

		init(how_many, workload_type);
	}

	/*
	 * This is the implementation of the quick sort algorithm that extends the
	 * Sort class's abstract sortNumbers() method.
	 * 
	 * It is really a wrapper for the private helper method, sortPartition(),
	 * which does the real "divide and conquer".
	 */
	public void sortNumbers() {
		sortPartition(0, numbers.length - 1);
		// counter = 0;
	}

	/*
	 * This is a helper method which is used by findPartition() to find the
	 * "pivot point" -- the place to divide the partition.
	 */
	private int findPivot(int left, int right) {
		return ((right + left) / 2);
	}

	/*
	 * This is a helper method called by sortNumbers(). It sorts an individual
	 * partition about the given pivot point.
	 */
	private int partition(int left, int right, int pivot) {
		do {
			while (numbers[++left] < numbers[pivot])
				;
			while ((right != 0) && (numbers[--right] > numbers[pivot]))
				;
			swapNumbers(left, right);
		} while (left < right);

		swapNumbers(left, right);

		return left;
	}

	/*
	 * This is a helper method called by sortNumbers(). It recursively calls
	 * itself on subpartitions to sort the numbers. The actual sorting within
	 * the partition is done by sortPartition(), which is iterative.
	 */
	private void sortPartition(int left, int right) {
		counter++;

		int pivot = findPivot(left, right);
		swapNumbers(pivot, right);
		int newpivot = partition(left - 1, right, right);
		swapNumbers(newpivot, right);

		if ((newpivot - left) > 1)
			sortPartition(left, newpivot - 1);
		if ((right - newpivot) > 1)
			sortPartition(newpivot + 1, right);
	}

	private int number;
	public int counter;

	protected void createWorstCase(int how_many) {
		// number = 0;
		// allocateNumber(0, how_many - 1);
		createBestCase(how_many);
	}

	protected void allocateNumber(int left, int right) {
		if (left == right) {
			numbers[left] = number++;
			return;
		}
		int position = (left + right) / 2;
		numbers[position] = number++;
		if (position - right >= 1)
			allocateNumber(position + 1, right);
		if (position - left >= 1)
			allocateNumber(left, position - 1);

	}
}
