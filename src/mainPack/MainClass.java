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
import graph.Graph;
import graph.Node;


//Passing filename as argument while running program



public class MainClass {

	public static void main(String[] args) throws IOException {
		
		Graph myGraph = new Graph();
		GraphMaker gM = new GraphMaker(args[0]);  //needs fixing and testing to take args/filename from terminal run
		
		myGraph = gM.createGraph();
		
		
		for(Node n:myGraph.getAdjNodes().keySet()) {
			System.out.println("-----------------");
			System.out.println("start"+n.getName());
			
			for(Node n2:myGraph.getAdjNodes().get(n)) {
				System.out.println(n2.getName());
			}
		}	

	}
}
