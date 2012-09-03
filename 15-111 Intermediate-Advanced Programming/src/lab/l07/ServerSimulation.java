package lab.l07;

/**
 * The Class simulating the activity of two Web servers, one using FIFO
 * scheduling and the other using Shortest Job First (JSF) scheduling (sing the
 * Heap). It simulates the processing of a collection of requests and report the
 * average service time for each of the two simulated servers.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 7
 */
public class ServerSimulation {
	private int kiloByteRate;
	private Heap heap;
	private FifoQueue queue;

	/**
	 * Constructs the ServerSimulation object. This also creates numObjects of
	 * WebObjects. Each of these object is copied. Then, one of them is enqueued
	 * in the Heap, a SJF queue, and the other in the FifoQueue. The
	 * kiloByteRate is set with specified value, which set the Web server's
	 * connection in terms of kilobytes of data per second.
	 * 
	 * @param numObjects
	 *            the number of WebObjects to be created.
	 * @param kiloByteRate
	 *            the speed of the Web server's connection in terms of kilobytes
	 *            of data per second.
	 */
	public ServerSimulation(int numObjects, int kiloByteRate) {
		// The numObjects should be always greater than 1. Otherwise, throw
		// exception.
		if (numObjects <= 0)
			throw new IllegalArgumentException();

		// Create the instance of the Heap and FifoQueue.
		heap = new Heap();
		queue = new FifoQueue();

		// Fill the heap and queue with creating WebObjects.
		while (numObjects > 0) {
			WebObject wObj = new WebObject();
			heap.insert(wObj);
			queue.insert(wObj.copy());
			numObjects--;
		}

		// Set the speed.
		this.kiloByteRate = kiloByteRate;
	}

	/**
	 * Calculates the average service time for a job on the FIFO-based Web
	 * server. It calculate the service time for each job by dividing its size
	 * in kilobytes by the kilobytes rate of the connection. A running total
	 * time accumulate the service time. Finally, dividing the total service
	 * time by the number of jobs will be returned as the average service time.
	 * 
	 * @return the average service time for a job on the FIFO-based Web server.
	 */
	public int calculateFIFOAverage() {
		// Initialize the data
		int delaySofar = 0;
		int sumOfDelays = 0;
		int countOfJobs = 0;

		// Calculate until the queue is not empty.
		while (!queue.isEmpty()) {
			// Increment the job count.
			countOfJobs++;

			// Accumulate the sum of delay time.
			sumOfDelays += delaySofar;

			// Get the Web Object.
			WebObject wObj = (WebObject) queue.removeMin();

			// Calculate the delay time on processing the Web Object.
			delaySofar += wObj.getSize() / this.kiloByteRate;
		}

		// Return the average service time.
		return sumOfDelays / countOfJobs;
	}

	/**
	 * Calculates the average service time for a job on the Shortest Job First
	 * (SJF) scheduling based Web server. It calculate the service time for each
	 * job by dividing its size in kilobytes by the kilobytes rate of the
	 * connection. A running total time accumulate the service time. Finally,
	 * dividing the total service time by the number of jobs will be returned as
	 * the average service time.
	 * 
	 * @return the average service time for a job on the Shortest Job First
	 *         (SJF) scheduling based Web server.
	 * @throws HeapException
	 */
	public int calculateSJFAverage() throws HeapException {
		// Initialize the data
		int delaySofar = 0;
		int sumOfDelays = 0;
		int countOfJobs = 0;

		// Calculate until the queue is not empty.
		while (!heap.isEmpty()) {
			// Increment the job count.
			countOfJobs++;

			// Accumulate the sum of delay time.
			sumOfDelays += delaySofar;

			// Get the Web Object.
			WebObject wObj = (WebObject) heap.removeMin();

			// Calculate the delay time on processing the Web Object.
			delaySofar += wObj.getSize() / this.kiloByteRate;
		}

		// Return the average service time.
		return sumOfDelays / countOfJobs;
	}
}
