package graph;

import java.util.HashMap;
import java.util.Map;

public class Prediction {

	
	//private Map<String, String> predMap = new HashMap<String, String>(); //day -> traffic
	private String roadName;
	private  double  p1 = 0.6, p2 = 0.2, p3 = 0.2;// p1 --> equals,  p2 --> pred-1, p3 --> pred+1
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
				p1 = p1 + 0.1;
				p2 = p2 - 0.05;
				p3 = p3 - 0.05;
				break;
			case 2:
				p1 = p1 - 0.05;
				p2 = p2 + 0.1;
				p3 = p3 - 0.05;
				break;
			default:
				p1 = p1 - 0.05;
				p2 = p2 - 0.05;
				p3 = p3 + 0.1;
		}
		
//		double smallest = Math.min(p1, Math.min(p2, p3));
//		double biggest = Math.max(p1, Math.max(p2,p3));
//		
//		p1 = (p1-smallest)/(biggest-smallest);
//		p2 = (p2-smallest)/(biggest-smallest);
//		p3 = (p3-smallest)/(biggest-smallest);
						
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
