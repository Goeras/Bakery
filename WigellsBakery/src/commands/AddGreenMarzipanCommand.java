package commands;

public class AddGreenMarzipanCommand implements CakeDecoratingCommand{

	@Override
	public void process() {
		
		System.out.println("Lägg marsipanlocket på tårtan(grönt).");
		
	}

}
