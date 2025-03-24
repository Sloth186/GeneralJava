package AoA.HW6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyList {
	List<LinkedList<Integer>> adjacencyList;
	
	public AdjacencyList(int numNodes) {
		adjacencyList = new ArrayList<LinkedList<Integer>>(numNodes);
	}
	
	void addEdge(int node1, int node2) {
		adjacencyList.get(node1).add(node2);
	}
}