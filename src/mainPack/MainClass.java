package mainPack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import fileHandler.GraphMaker;
import graph.ActualTraffic;
import graph.Edge;
import graph.Graph;
import graph.Node;
import graph.Prediction;


//Passing filename as argument while running program



public class MainClass {

	public static void main(String[] args) throws IOException {
		
		Graph myGraph = new Graph();
		GraphMaker gM = new GraphMaker(args[0]);  //needs fixing and testing to take args/filename from terminal run
		
		myGraph = gM.createGraph();
		
//		
//		for(Node n:myGraph.getAdjNodes().keySet()) {
//			System.out.println("-----------------");
//			System.out.println("start"+n.getName());
//			Edge e1 = null;
//			for(Node n2:myGraph.getAdjNodes().get(n)) {
//				for (Edge e : myGraph.getEdgesList()) {
//					if (e.getSrcNode().getName().equals(n.getName()) && e.getDestNode().getName().equals(n2.getName())) {
//						System.out.println("Goes to : " + n2.getName() + " with road " + e.getRoadName());
//					}
//					
//				}
//				
//				
//			}
//		}	
//
		for (int day=0;day<2;day++) {
		for (Prediction p : myGraph.getPredictions().get(day)) {
			System.out.println("Road : " + p.getRoadName() +" will have traffic " + p.getTraffic());
		}
		}
		
		
		
		for (int day=0;day<2;day++) {
			System.out.println("----------------------");
			for (ActualTraffic a : myGraph.getActualTraffic().get(day)) {
				
				System.out.println("Road : " + a.getRoadName() +" has traffic " + a.getTraffic());
			}
		}
	}
}

