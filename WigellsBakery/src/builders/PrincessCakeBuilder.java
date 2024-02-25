package builders;

import businessObjects.PrincessCake;

// i Builder-klasserna sätts värden på tårtans alla attribut. endast ID tas via inparameter i detta fall.
public class PrincessCakeBuilder{
	
	PrincessCake cake = new PrincessCake();
	
	public PrincessCakeBuilder addName() {
		cake.setName("Prinsesstårta");
		return this;
	}
	public PrincessCakeBuilder addFirstCakeBottom() {
		cake.setFirstCakeBottom("tårtbotten");
		System.out.println("Ta fram en "+cake.getFirstCakeBottom());
		return this;
	}
	
	public PrincessCakeBuilder addFirstCream() {
		cake.setFirstCream("vaniljkräm");
		System.out.println("Bred på ett lager "+cake.getFirstCream());
		return this;
	}
	
	public PrincessCakeBuilder addSecondCakeBottom() {
		cake.setSecondCakeBottom("tårtbotten");
		System.out.println("Lägg på en "+cake.getSecondCakeBottom());
		return this;
	}
	
	public PrincessCakeBuilder addSecondCream() {
		cake.setSecondCream("vaniljkräm");
		System.out.println("Ta fram en "+cake.getSecondCream());
		return this;
	}
	public PrincessCakeBuilder addThirdCakeBottom() {
		cake.setThirdCakeBottom("tårtbotten");
		System.out.println("Lägg på en "+cake.getThirdCakeBottom());
		return this;
	}
	
	public PrincessCakeBuilder addToppings() {
		cake.setCover("grönt marsipanlock");
		cake.setDecor("marsipanros");
		cake.setSprinkle("florsocker");
		return this;
	}
	public PrincessCakeBuilder addId(int id) {
		cake.setiD(id);
		return this;
	}
	public PrincessCake build() {
		if(cake.getiD() == 0) { 
			throw new RuntimeException("Tårtan har inget ID");
		}
		return cake;
	}

}
