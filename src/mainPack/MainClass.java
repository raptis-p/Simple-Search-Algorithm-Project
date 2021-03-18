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
		
		
		for(Map.Entry<Node, List<Node>> e : myGraph.getAdjNodes().entrySet()){
				System.out.println(e.getKey().getName()+" = ");
			    for(Node e1 : e.getValue()){
			      System.out.println(e1.getName());			
			}
		}	

	}
}
