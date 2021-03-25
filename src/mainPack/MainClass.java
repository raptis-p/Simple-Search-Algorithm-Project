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
import searchAlgorithms.IDAstar;
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
		
		for (int day=0;day<80;day++) {
			myGraph.resetCosts_Path();
//			System.out.println("--------- fdjfdffd    fdsfdsfd   alaksaaaaaaaaa----------------");
//			System.out.println("Day : "+day);
			//predict traffic
			myGraph.predictTrafficInDay(day);
			
//			for (Edge e :myGraph.getEdgesList()) {
//				System.out.println(e.toStringPred());
//			}
			//maybe remove some streets
			//based on predictions
			
			
			System.out.println("-------------------DFS(Night)---------------------");
			IDS ids = new IDS(myGraph);
//			for (Node n: myGraph.getDestNode().getPathFromSrc()) {
//				System.out.println(n.getName() + "      " + n.getCost()
//				);
//				
//			}
			System.out.println("--------------------------------------------------");
			//myGraph.resetCosts_Path();
//
			
//			for (Node n : myGraph.getNodesList()) {
//				System.out.println(n.getName() + "       " + n.getHeuristic());
//			}
//			//execute IDS
			
			
			//set actual traffic values
			myGraph.setActualTrafficInDay(day);
			System.out.println("------------------DFS(Morning)-------------------");
			//execute path with actual traffic
			int sum=0;
			int i = 0;
			Node n5 = myGraph.getDestNode().getPathFromSrc().get(i);
			for (Node n1 : myGraph.getDestNode().getPathFromSrc()) {
				i++;
				if (n1.getName().equals(myGraph.getDestNode().getPathFromSrc().get(0).getName())) continue;
				System.out.println(n1.getName());
				//For node n -> next node -> findWeight but with real instead of predicted values
				sum += myGraph.findRealWeight(n5,n1);
				if (i>= myGraph.getDestNode().getPathFromSrc().size()) break;
				n5 = myGraph.getDestNode().getPathFromSrc().get(i);
				
				if (n1.getName().equals(myGraph.getDestNode().getName())) break;
			}
			System.out.println("Predicted Cost of Path: " +myGraph.getDestNode().getCost() );
			System.out.println("Real Cost of Path: " + sum);
			//print Visited Nodes Number, (exec time)
			//sequence of edges(with their weights), total predicted cost
			//and total real cost
			System.out.println("--------------------------------------------------");
			//execute IDA*
			//reset visited but not costs
			System.out.println("-------------------A*(Night)----------------------");
			IDAstar ida = new IDAstar(myGraph);
			
			for (Node n : myGraph.getDestNode().getPathFromSrc())
			System.out.println(n.getName() + "     " +n.getCost());
			//use path with actual traffic
			System.out.println("---------------------------------------------------");
			
			//print Visited Nodes Number, (exec time)
			//sequence of edges(with their weights), total predicted cost
			//and total real cost
			
			//update p1,p2,p3
			
			//go to next day
		}
		
	}
	
}

