package businessObjects;

import java.util.HashMap;
import java.util.Map;

public class Customer {
	
	private String name;
	private int iD;
	private Map<Integer, Cake> cakes = new HashMap<>(); // Kundens tårtor spara i en HashMap med key(ID),value(Tårtobjektet)
	
	public Customer() {}
	
	public Customer(String name, int iD) {
		this.name = name;
		this.iD = iD;
	}
	
	public void addCake(int cakeId, Cake cake) {
		cakes.put(cakeId, cake);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public int getCustomerNumber() {
		return iD;
	}

	public void setCustomerNumber(int iD) {
		this.iD = iD;
	}

	public Map<Integer, Cake> getCakes() {
		return cakes;
	}
	public void setCakes(Map<Integer, Cake> cakes) {
		this.cakes = cakes;
	}

}
