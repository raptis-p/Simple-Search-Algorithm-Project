package mainPack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import fileHandler.GraphMaker;
import graph.ActualTraffic;
import graph.Edge;
import graph.Graph;
import graph.Node;
import graph.Prediction;
import searchAlgorithms.IDS;


//Passing filename as argument while running program



public class MainClass {

	public static void main(String[] args) throws IOException {
		
		Graph myGraph = new Graph();
		GraphMaker gM = new GraphMaker(args[0]);  //needs fixing and testing to take args/filename from terminal run
		
		myGraph = gM.createGraph();
		
////		
//		for (Node n : myGraph.getAdjNodes().keySet()) {
//			for (Node n2 : myGraph.getAdjNodes().get(n)) {
//				System.out.println("Node " + n.getName() +" is connected with " +n2.getName());
//			}
//		}

//		for (int day=0;day<2;day++) {
//		for (Prediction p : myGraph.getPredictions().get(day)) {
//			System.out.println("Road : " + p.getRoadName() +" will have traffic " + p.getTraffic());
//		}
//		}
//		
//		
//		
//		for (int day=0;day<2;day++) {
//			System.out.println("----------------------");
//			for (ActualTraffic a : myGraph.getActualTraffic().get(day)) {
//				
//				System.out.println("Road : " + a.getRoadName() +" has traffic " + a.getTraffic());
//			}
//		}
		
//		System.out.println(myGraph.getSrcNode().getName());
//		System.out.println(myGraph.getDestNode().getName());
		
//		for (int day=0;day<3;day++) {
//		
//		
//		//predict traffic
//		myGraph.predictTrafficInDay(day);
//		
//		for (Edge e :myGraph.getEdgesList()) {
//			System.out.println(e.toStringPred());
//		}
//		//maybe remove some streets
//		//based on predictions
//		
//		
//		
//		//execute IDS
//		
//		
//		//set actual traffic values
//		myGraph.setActualTrafficInDay(day);
//		
//		//execute path with actual traffic
//		
//		
//		//print Visited Nodes Number, (exec time)
//		//sequence of edges(with their weights), total predicted cost
//		//and total real cost
//		
//		//execute IDA*
//		
//		//use path with actual traffic
//		
//		
//		//print Visited Nodes Number, (exec time)
//		//sequence of edges(with their weights), total predicted cost
//		//and total real cost
//		
//		//update p1,p2,p3
//		
//		//go to next day
//	}
//		
		
		
		IDS ids = new IDS(myGraph);
//		System.out.println(myGraph.getDestNode().getName());
		for (Edge e : myGraph.getDestNode().getPathFromSrc()) {
			System.out.println(e.getRoadName());
		}
		
		Node n1 = new Node();
		for (Node n : myGraph.getAdjNodes().keySet()) {
			if (n.getName().equals(" 10Node3e")) {
				n1 = n;
			}
		}
		for(int i=0;i<n1.getPathFromSrc().size();i++)
		System.out.println(n1.getPathFromSrc().get(i).getRoadName());
	}
	
}

