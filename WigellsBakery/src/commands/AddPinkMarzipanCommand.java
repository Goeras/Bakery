package commands;

public class AddPinkMarzipanCommand implements CakeDecoratingCommand{

	@Override
	public void process() {
		
		System.out.println("Lägg marsipanlocket på tårtan(rosa).");
		
	}

}
