package graph;

import java.util.HashMap;
import java.util.Map;

public class Prediction {

	
	//private Map<String, String> predMap = new HashMap<String, String>(); //day -> traffic
	private String roadName;
	private static double p1 = 0.6,p2 = 0.3,p3 = 0.1;
	private int successRatio;
	private int traffic;   //-1 = low, 0 = normal, 1 = high

	
	
	//Constructor
	public Prediction(String rN, int tr) {
		this.roadName = rN;
		this.traffic = tr;
	}
	
	public void updateP(int actTrafficNext) {   // actual traffic of day
		this.successRatio=0;
		if (this.traffic < actTrafficNext) {
			this.successRatio--;
		}
		else if (this.traffic == actTrafficNext) {
			
		}
		else {
			this.successRatio++;
		}
		
		//update p 
		
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
