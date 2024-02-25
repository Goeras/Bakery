package commands;

public class AddChocolateGanashCommand implements CakeDecoratingCommand{

	@Override
	public void process() {
		
		System.out.println("Häll chokladganash på tårtan. Låt det rinna över kanten.");
		
	}

}
