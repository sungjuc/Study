package lab.l07;

/**
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 7
 */
public class ServerEvaluation {
	public static void main(String[] args) throws HeapException {
		int numOfObjects = 10;
		int kiloByteRate = 1;
		ServerSimulation server = new ServerSimulation(numOfObjects,
				kiloByteRate);
		System.out.println("The number of Web Objects: " + numOfObjects);
		System.out.println("The rate of kilobytes processing: " + kiloByteRate);
		System.out.println("-------------------------------------------------");
		System.out.println("The average service time of FIFO: "
				+ server.calculateFIFOAverage());
		System.out.println("The average service time of SJF: "
				+ server.calculateSJFAverage());
		System.out.println("-------------------------------------------------");

		numOfObjects = 10000;
		kiloByteRate = 100;
		server = new ServerSimulation(numOfObjects, kiloByteRate);
		System.out.println("The number of Web Objects: " + numOfObjects);
		System.out.println("The rate of kilobytes processing: " + kiloByteRate);
		System.out.println("-------------------------------------------------");
		System.out.println("The average service time of FIFO: "
				+ server.calculateFIFOAverage());
		System.out.println("The average service time of SJF: "
				+ server.calculateSJFAverage());
		System.out.println("-------------------------------------------------");
	}
}
