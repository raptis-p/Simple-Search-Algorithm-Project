package graph;

public class ActualTraffic {

	private String roadName;
	private int traffic;
	
	
	//Constructor
	public ActualTraffic(String r, int t) {
		this.roadName = r;
		this.traffic = t;
	}
	
	
	public String getRoadName() {
		return this.roadName;
	}
	public void setRoadName(String rn) {
		this.roadName = rn;
	}
	public int getTraffic() {
		return this.traffic;
	}
	public void setTraffic(int traffic) {
		this.traffic = traffic;
	}
	

	
	
	
}
