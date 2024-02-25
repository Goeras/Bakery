package bakery;

import businessObjects.VD;

public class Main {

	public static void main(String[] args) {
		
		CakeBakerySystem cakeBakerySystem = new CakeBakerySystem();
		
		CakeOrderHandler cakeOrderHandler = CakeOrderHandler.getInstance(); // skapar upp instans av CakeOrderHandler
		VD vd = VD.getInstance(); // skapar upp instans av VD
		cakeOrderHandler.addPropertyChangeListener(vd); // Lägger till vd som lyssanare.
		
		cakeBakerySystem.mainMenu();
		
		System.out.println("Tack å hej, leverpastej");
	}

}

// I detta program kan man skapa upp olika kund-konton, där det är möjligt att beställa tårtor och se sin historik.
// För att byta emellan olika kund-konton så loggar man in på det man vill med hjälp av ID/kundnummer.
// Detta för att tex kunna switcha mellan olika kunder och se historiska beställningar, samt göra nya beställningar kopplade till samma kund.

// VD'n får en notis när en ny tårta är beställt, samt när tårtan är klar.