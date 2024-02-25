package commands;

public class AddWhippedCreamCommand implements CakeDecoratingCommand{

	@Override
	public void process() {

		System.out.println("Fördela hårt vispad grädde på tårtan så den får en kupolform.");

	}

}
