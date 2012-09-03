package lab.l04;

class BubbleSort extends Sort {
	/*
	 * You should implement this. It is the meat of the constructor and is also
	 * used by the reset() method.
	 * 
	 * It will create the BubbleSort object with an "unsorted" list.
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

	public BubbleSort(int how_many, int workload_type) {
		this.how_many = how_many;
		this.workload_type = workload_type;

		init(how_many, workload_type);
	}

	/*
	 * This is the implementation of the bubble sort algorithm that extends the
	 * Sort class's abstract sortNumbers() method.
	 */
	public void sortNumbers() {
		for (int look_for = 0; look_for < numbers.length; look_for++)
			for (int swapping = numbers.length - 1; swapping > look_for; swapping--)
				if (numbers[swapping - 1] > numbers[swapping])
					swapNumbers(swapping - 1, swapping);
	}
}
