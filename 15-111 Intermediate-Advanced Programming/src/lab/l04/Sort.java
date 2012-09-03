package lab.l04;

import java.util.Random;
import java.util.Date;

abstract class Sort {
	// Number of times to run each sort, the more iterations the better
	// the time estimate provided.
	private final static int ITERATIONS = 10;
	private final static int MIN_SIZE = 3000; // Smallest size list to test
	private final static int MAX_SIZE = 24000; // largest size list to test

	protected long start_time;
	protected int numbers[]; // list of numbers to sort (and then sorted)
	protected int how_many, workload_type;

	protected static final int BEST_CASE = 1;
	protected static final int AVG_CASE = 2;
	protected static final int WORST_CASE = 3;

	protected long numswaps; // incremented after each swap

	/*
	 * This class runs the sorts with your workloads and collects timing
	 * information. Depending on the speed of your machine, it could take hours
	 * to run. We suggest that, to collect your results, you run it paramterized
	 * as shown above. But, you probably want to test your workloads with much
	 * smaller lists and fewer iterations, first.
	 * 
	 * If you abolutely can't wait for the results, reduce the number of
	 * ITERATIONS, perhaps all the way to 1. This makes your results a little
	 * less reliable, since outliers can get in the way, but... If it is still
	 * going to slowly for you to finish on time, try only MAX_SIZE=12000 ...or
	 * even MAX_SIZE=6000 iterations. If you have to reduce MAX_SIZE below
	 * 24000, also reduce MIN_LIST to 1500 or 750.
	 */
	public static void main(String[] args) {
		Sort s;
		/*
		 * System.out.println("Bubble Sort: Best Case"); for (int n = MIN_SIZE;
		 * n <= MAX_SIZE; n *= 2) { s = new BubbleSort(n, BEST_CASE);
		 * s.report(n); }
		 * 
		 * System.out.println("Bubble Sort: Average Case"); for (int n =
		 * MIN_SIZE; n <= MAX_SIZE; n *= 2) { s = new BubbleSort(n, AVG_CASE);
		 * s.report(n); }
		 * 
		 * System.out.println("Bubble Sort: Worst Case"); for (int n = MIN_SIZE;
		 * n <= MAX_SIZE; n *= 2) { s = new BubbleSort(n, WORST_CASE);
		 * s.report(n); }
		 * 
		 * System.out.println("Insertion Sort: Best Case"); for (int n =
		 * MIN_SIZE; n <= MAX_SIZE; n *= 2) { s = new InsertionSort(n,
		 * BEST_CASE); s.report(n); }
		 * 
		 * System.out.println("Insertion Sort: Average Case"); for (int n =
		 * MIN_SIZE; n <= MAX_SIZE; n *= 2) { s = new InsertionSort(n,
		 * AVG_CASE); s.report(n); }
		 * 
		 * System.out.println("Insertion Sort: Worst Case"); for (int n =
		 * MIN_SIZE; n <= MAX_SIZE; n *= 2) { s = new InsertionSort(n,
		 * WORST_CASE); s.report(n); }
		 */
		System.out.println("Selection Sort: Best Case");
		for (int n = MIN_SIZE; n <= MAX_SIZE; n *= 2) {
			s = new SelectionSort(n, BEST_CASE);
			s.report(n);
		}

		System.out.println("Selection Sort: Average Case");
		for (int n = MIN_SIZE; n <= MAX_SIZE; n *= 2) {
			s = new SelectionSort(n, AVG_CASE);
			s.report(n);
		}

		System.out.println("Selection Sort: Worst Case");
		for (int n = MIN_SIZE; n <= MAX_SIZE; n *= 2) {
			s = new SelectionSort(n, WORST_CASE);
			s.report(n);
		}

		System.out.println("Quick Sort: Best Case");
		for (int n = MIN_SIZE; n <= MAX_SIZE; n *= 2) {
			s = new QuickSort(n, BEST_CASE);
			s.report(n);
		}

		System.out.println("Quick Sort: Average Case");
		for (int n = MIN_SIZE; n <= MAX_SIZE; n *= 2) {
			QuickSort s1 = new QuickSort(n, AVG_CASE);
			s1.report(n);
			System.out.println("---" + s1.counter);
		}

		System.out.println("Quick Sort: Worst Case");
		for (int n = MIN_SIZE; n <= MAX_SIZE; n *= 2) {
			QuickSort s1 = new QuickSort(n, WORST_CASE);
			s1.report(n);
			System.out.println("---" + s1.counter);
		}
	}

	/*
	 * This resets a Sort object to an unsorted list with exactly the same
	 * parameters, so tests can be rerun for accuracy
	 */
	public void reset() {
		init(how_many, workload_type);
	}

	/*
	 * This method performs multiple iterations of the same test and reports the
	 * average. It is used for accuracy.
	 */
	public void report(int n) {
		numswaps = 0;
		long elapsed_time = 0;

		for (int count = 0; count < ITERATIONS; count++) {
			reset();
			startTiming();
			sortNumbers();
			elapsed_time += getElapsedTime();
		}

		System.out.println(" " + n + " " + elapsed_time / ITERATIONS
				+ " msecs " + numswaps / ITERATIONS + " swaps");
	}

	/*
	 * This method simply prints the list of number in whatever order they
	 * happen to be in
	 */
	public void printNumbers() {
		for (int i = 0; i < numbers.length; i++)
			System.out.println(numbers[i] + "\t");
		System.out.println("***");
	}

	/*
	 * This method is just here as a convenience to the derived sorts. Many of
	 * the sorts will need to swap numbers within the list.
	 */
	protected void swapNumbers(int x, int y) {
		if (x == y)
			return;
		numswaps++;
		int t = numbers[x];
		numbers[x] = numbers[y];
		numbers[y] = t;
	}

	/*
	 * This method starts a millisecond "stopwatch" you might want to use it for
	 * timing. It works in conjunction with getElapsedTime() below
	 */
	protected void startTiming() {
		start_time = (new Date()).getTime();
	}

	/*
	 * This method reports an elapsed time. startTiming() (above) must be called
	 * to start the timing. This method reports the amount of time in between
	 * the startTiming() and the call to getElapsedTime() in milliseconds.
	 * 
	 * You might want to use this in your main methods
	 */
	protected long getElapsedTime() {
		return ((new Date()).getTime()) - start_time;
	}

	/*
	 * You might want to implement other protected methods so that you can use
	 * them in your indidivudal sort class. For example, you might want a method
	 * to generate a random list of numbers, or a list of ascending numbers, or
	 * a list of descending numbers. Basically, this is a good place to put
	 * helper methods that will be used by more than one derived type. They
	 * should be protected to ensure that they are accessible by the derived
	 * type, while ensuring that they are not externially visible behvaiors of
	 * the sort objects.
	 */

	/*
	 * This method should be extended by each specific sort and should sort the
	 * list of numbers using the specific sort.
	 */
	abstract public void sortNumbers();

	abstract protected void init(int how_many, int workload_type);

	protected void createBestCase(int how_many) {
		for (int i = 0; i < how_many; i++) {
			numbers[i] = i;
		}
	}

	protected void createAverageCase(int how_many) {
		createBestCase(how_many);
		shuffle(numbers);
	}

	protected void createWorstCase(int how_many) {
		for (int i = how_many; i > 0; i--) {
			numbers[how_many - i] = i;
		}
	}

	protected void shuffle(int[] array) {
		Random random = new Random();
		// i is the number of items remaining to be shuffled.
		for (int i = array.length; i > 1; i--) {
			// Pick a random element to swap with the i-th element.
			int j = random.nextInt(i); // 0 <= j <= i-1 (0-based array)
			// Swap array elements.
			int tmp = array[j];
			array[j] = array[i - 1];
			array[i - 1] = tmp;
		}
	}

	/*
	 * You shouldn't implement any other public methods (usual policy)
	 */
}
