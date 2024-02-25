package commands;

public class AddRoseCommand implements CakeDecoratingCommand{

	@Override
	public void process() {
		
		System.out.println("Garnera med en marsipanros.");
		
	}

}
