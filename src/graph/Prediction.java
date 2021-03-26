package graph;

import java.util.HashMap;
import java.util.Map;

public class Prediction {

	
	//private Map<String, String> predMap = new HashMap<String, String>(); //day -> traffic
	private String roadName;
	private static double p1 = 0.5, p2 = 0.3, p3 = 0.2;// p1 --> equals,  p2 --> pred-1, p3 --> pred+1
	private int successRatio;
	private int traffic;   //-1 = low, 0 = normal, 1 = high

	
	
	//Constructor
	public Prediction(String rN, int tr) {
		this.roadName = rN;
		this.traffic = tr;
	}
	
	public void updateP(int i,int size) {   // actual traffic of day
		//update p 
		switch(i)
		{
			case 1:
				p1 = p1 + 1/size;
				p2 = p2 - (1/size*2);
				p3 = p3 - (1/size*2);
				break;
			case 2:
				p1 = p1 - (1/size*2);
				p2 = p2 + 1/size;
				p3 = p3 - (1/size*2);
				break;
			default:
				p1 = p1 - (1/size*2);
				p2 = p2 - (1/size*2);
				p3 = p3 + 1/size;
		}
		
	}
	
	
	
	
	
	
	//Getters-Setters
	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public double getP1() {
		return p1;
	}

	public void setP1(double p1) {
		this.p1 = p1;
	}

	public double getP2() {
		return p2;
	}

	public void setP2(double p2) {
		this.p2 = p2;
	}

	public double getP3() {
		return p3;
	}

	public void setP3(double p3) {
		this.p3 = p3;
	}

	public int getTraffic() {
		return traffic;
	}

	public void setTraffic(int traffic) {
		this.traffic = traffic;
	}

	public double getSuccessRatio() {
		return successRatio;
	}

	public void setSuccessRatio(int successRatio) {
		this.successRatio = successRatio;
	}
	
	
	
	
}
