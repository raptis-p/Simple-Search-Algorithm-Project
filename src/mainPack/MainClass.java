package mainPack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import fileHandler.GraphMaker;
import graph.Graph;
import graph.Node;


//Passing filename as argument while running program



public class MainClass {

	public static void main(String[] args) throws IOException {
		
		Graph myGraph = new Graph();
		GraphMaker gM = new GraphMaker(args[0]);  //needs fixing and testing to take args/filename from terminal run
		
		myGraph = gM.createGraph();
		
		//System.out.println(myGraph.getAdjNodes().keySet());
//		for (int i=0;i<5;i++) {
//		Map.Entry<Node, List<Node>> entry = myGraph.getAdjNodes().entrySet().iterator().next();
//		
//		String name = entry.getKey().getName();
//		System.out.println(name);
//		
//		String val = entry.getValue().toString();
//		System.out.println(val);
//		
//		
//	
		
//		System.out.println(myGraph.getAdjNodes().values());
//		for (int i=0;i<5;i++) {
//		System.out.println(myGraph.getEdgesList().get(i).toString());
//		}
		
		
//		for (int i=0;i<5;i++) {
//		System.out.println(myGraph.getAdjNodes().values());
//		}
		
		for (Node n : myGraph.getAdjNodes().keySet()) {
			System.out.println("Node : " + n.getName());
			System.out.println("AdjList : " + myGraph.getAdjNodes().get(n));
		}
	}

}
