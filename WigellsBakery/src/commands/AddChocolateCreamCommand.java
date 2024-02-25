package commands;

public class AddChocolateCreamCommand implements CakeDecoratingCommand{

	@Override
	public void process() {
		
		System.out.println("Spackla tårtan med chokladsmörkräm.");
		
	}

}
