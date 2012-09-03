package lab.l08;

import junit.framework.TestCase;
import lab.l08.RoadMap.DijTableEntry;

public class RoadMapTest extends TestCase {
	public void testRoadMap() {
		String mapFile = "src/lab/l08/sampleMap.txt";
		RoadMap roadMap = new RoadMap(mapFile);
		DijTableEntry[] resultTable = roadMap.dijkstra("Atlanta", true);

		roadMap.printPath(resultTable, "Atlanta");
		roadMap.printPath(resultTable, "Charleston");
		roadMap.printPath(resultTable, "Pittsburgh");
		roadMap.printPath(resultTable, "Philadelphia");
		roadMap.printPath(resultTable, "DC");

		resultTable = roadMap.dijkstra("Charleston", true);
		
		roadMap.printPath(resultTable, "Atlanta");
		roadMap.printPath(resultTable, "Charleston");
		roadMap.printPath(resultTable, "Pittsburgh");
		roadMap.printPath(resultTable, "Philadelphia");
		roadMap.printPath(resultTable, "DC");
	}
}
