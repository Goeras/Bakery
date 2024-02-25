package builders;

import businessObjects.ChocolateCake;

//i Builder-klasserna sätts värden på tårtans alla attribut. endast ID tas via inparameter i detta fall.
public class ChocolateCakeBuilder {
	ChocolateCake cake = new ChocolateCake();
	
	public ChocolateCakeBuilder addName() {
		cake.setName("Chokladtårta");
		return this;
	}
	public ChocolateCakeBuilder addFirstCakeBottom() {
		cake.setFirstCakeBottom("chokladtårtbotten");
		System.out.println("Ta fram en "+cake.getFirstCakeBottom());
		return this;
	}
	
	public ChocolateCakeBuilder addFirstCream() {
		cake.setFirstCream("hallonmousse");
		System.out.println("Bred på ett lager "+cake.getFirstCream());
		return this;
	}
	
	public ChocolateCakeBuilder addSecondCakeBottom() {
		cake.setSecondCakeBottom("chokladtårtbotten");
		System.out.println("Lägg på en "+cake.getSecondCakeBottom());
		return this;
	}
	
	public ChocolateCakeBuilder addSecondCream() {
		cake.setSecondCream("hallonmousse");
		System.out.println("Ta fram en "+cake.getSecondCream());
		return this;
	}
	public ChocolateCakeBuilder addThirdCakeBottom() {
		cake.setThirdCakeBottom("chokladtårtbotten");
		System.out.println("Lägg på en "+cake.getThirdCakeBottom());
		return this;
	}
	
	public ChocolateCakeBuilder addToppings() {
		cake.setCover("chokladsmörkräm");
		cake.setDecor("chokladganash");
		cake.setSprinkle("hallon");
		return this;
	}
	public ChocolateCakeBuilder addId(int id) {
		cake.setiD(id);
		return this;
	}
	public ChocolateCake build() {
		if(cake.getiD() == 0) {
			throw new RuntimeException("Tårtan har inget ID");
		}
		return cake;
	}

}
