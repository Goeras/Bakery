package builders;

import businessObjects.OperaCake;

//i Builder-klasserna sätts värden på tårtans alla attribut. endast ID tas via inparameter i detta fall.
public class OperaCakeBuilder {
	OperaCake cake = new OperaCake();
	
	public OperaCakeBuilder addName() {
		cake.setName("Operatårta");
		return this;
	}
	public OperaCakeBuilder addFirstCakeBottom() {
		cake.setFirstCakeBottom("tårtbotten");
		System.out.println("Ta fram en "+cake.getFirstCakeBottom());
		return this;
	}
	
	public OperaCakeBuilder addFirstCream() {
		cake.setFirstCream("vaniljkräm");
		System.out.println("Bred på ett lager "+cake.getFirstCream());
		return this;
	}
	
	public OperaCakeBuilder addSecondCakeBottom() {
		cake.setSecondCakeBottom("tårtbotten");
		System.out.println("Lägg på en "+cake.getSecondCakeBottom());
		return this;
	}
	
	public OperaCakeBuilder addSecondCream() {
		cake.setSecondCream("hallonsylt");
		System.out.println("Ta fram en "+cake.getSecondCream());
		return this;
	}
	public OperaCakeBuilder addThirdCakeBottom() {
		cake.setThirdCakeBottom("tårtbotten");
		System.out.println("Lägg på en "+cake.getThirdCakeBottom());
		return this;
	}
	
	public OperaCakeBuilder addToppings() {
		cake.setCover("rosa marsipanlock");
		cake.setDecor("marsipanros");
		cake.setSprinkle("florsocker");
		return this;
	}
	public OperaCakeBuilder addId(int id) {
		cake.setiD(id);
		return this;
	}
	public OperaCake build() {
		if(cake.getiD() == 0) { 
			throw new RuntimeException("Tårtan har inget ID");
		}
		return cake;
	}

	
}
