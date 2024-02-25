package commands;

public class AddRaspberryCommand implements CakeDecoratingCommand{

	@Override
	public void process() {
		
		System.out.println("Garnera med hallon.");
		
	}

}
