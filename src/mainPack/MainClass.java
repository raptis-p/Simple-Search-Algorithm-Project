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
		myGraph.initializeNeighbors();
		
		
//		for (Node n : myGraph.getNodesList()) {
//			System.out.println(n.getName());
//			System.out.println("-------------");
//			for (Node n1 : n.getNeighbors()) {
//				System.out.println("Neighbor : " + n1.getName());
//			}
//			System.out.println("-------------");
//		}
//		
		
		//IDS ids = new IDS(myGraph);
//		Node s = myGraph.getSrcNode();
//		System.out.println(myGraph.getSrcNode().getName());
//		System.out.println(s.getNeighbors().size());
//		
		//maybe remove some streets with same src-dest and 
		//big difference in weight values
		
		for (int day=0;day<2;day++) {
			
			System.out.println("--------- fdjfdffd    fdsfdsfd   alaksaaaaaaaaa----------------");
			System.out.println("Day : "+day);
			//predict traffic
			myGraph.predictTrafficInDay(day);
			
//			for (Edge e :myGraph.getEdgesList()) {
//				//System.out.println(e.toStringPred());
//			}
			//maybe remove some streets
			//based on predictions
			
			
			
			IDS ids = new IDS(myGraph);
			myGraph.resetCosts_Path();
			
			//execute IDS
			
			
			//set actual traffic values
			//myGraph.setActualTrafficInDay(day);
			
			//execute path with actual traffic
			
			
			//print Visited Nodes Number, (exec time)
			//sequence of edges(with their weights), total predicted cost
			//and total real cost
			
			//execute IDA*
			
			//use path with actual traffic
			
			
			//print Visited Nodes Number, (exec time)
			//sequence of edges(with their weights), total predicted cost
			//and total real cost
			
			//update p1,p2,p3
			
			//go to next day
		}
		
	}
	
}

