package commands;

import java.util.ArrayList;

public class CakeDecoratingPipeline {

	private ArrayList<CakeDecoratingCommand> pipeline = new ArrayList<>(); // Pipeline för commands som skall köras.
	
	public void addCommand(CakeDecoratingCommand command) {
		pipeline.add(command);
	}
	
	public void execute() {
		for(CakeDecoratingCommand command : pipeline) {
			command.process(); // utför alla commands som ligger i pipen i den sekvens de lades till.
		}
		
		// Här skulle vi alltså kunna ha en typ av "undo" metod i omvänd ordning utifrån pipeline.
	}
	
}
