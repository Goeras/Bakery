package bakery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import builders.ChocolateCakeBuilder;
import builders.OperaCakeBuilder;
import builders.PrincessCakeBuilder;
import businessObjects.Cake;
import businessObjects.Customer;
import businessObjects.VD;
import commands.AddChocolateCreamCommand;
import commands.AddChocolateGanashCommand;
import commands.AddGreenMarzipanCommand;
import commands.AddPinkMarzipanCommand;
import commands.AddRaspberryCommand;
import commands.AddRoseCommand;
import commands.AddWhippedCreamCommand;
import commands.CakeDecoratingPipeline;

public class CakeBakerySystem {
	
	Scanner sc = new Scanner(System.in);
	List<Customer> customers = new ArrayList<>();
	Customer customer; // Variabel för att hålla inloggad kund. 
	
	public void mainMenu() { // Huvudmeny.
		boolean continueMainMenu = true;
		
		while(continueMainMenu) {
			
			printMenu();
			String choice = sc.nextLine();
			
			switch(choice) {
			
			case "1": // Tårtbeställning.
				if(customer == null) { // Kollar så att en kund är "inloggad".
				customer = customerLogIn();
				}
				else if(!(customer == null)) {
					orderNewCake(customer);
				}
				break;

			case "2": // Se kundens historiska beställningar.
				if(customer == null) {
					customer = customerLogIn();
					}
				else if(!(customer == null)) {
					orderHistory(customer);
				}
				break;
			case "3": // logga in befintlig kund med ID.
				customer = customerLogIn();
				break;
				
			case "4": // Skapa ny kund.
				customer = newCustomer();
				break;
				
			case "9":
				continueMainMenu = false;
				break;
			}
		}
	}
	
	public void printMenu() {
		System.out.println("*********MENY*********\n"
				         + "(1)  Tårtbeställning  \n"
				         + "(2)  Historik         \n"
				         + "(3)  Logga in med ID  \n"
				         + "(4)  Lägg till ny kund\n"
				         + "(9)  Avsluta        ");
	}
	
	public void printCakeAlternatives() {

		System.out.println("Vilken typ av tårta vill du beställa?\n"
				+ "(1)  Princesstårta\n"
				+ "(2)  Operatårta\n"
				+ "(3)  Chokladtårta\n"
				+ "(9)  Återgå");
	}

	public void orderNewCake(Customer customer) {
		
		boolean continueCakeMenu = true;
		boolean cakeOrdered = false;
		String cakeType = "";
		
		while(continueCakeMenu) {
			
			printCakeAlternatives();
			
			String input = sc.nextLine();

			switch(input) {
			case "1":
				cakeType = "Princess";
				cakeOrdered = true;
				continueCakeMenu = false;
				break;

			case "2":
				cakeType = "Opera";
				cakeOrdered = true;
				continueCakeMenu = false;
				break;

			case "3":
				cakeType = "Choklad";
				cakeOrdered = true;
				continueCakeMenu = false;
				break;
			case "9":
				continueCakeMenu = false;
				break;

			default:
				System.out.println("Välj ett giltigt alternativ: 1 / 2 / 3 ( eller 9 för att återgå till huvudmeny).\n");
				break;
			}
		}
		if(cakeOrdered) {
			CakeOrderHandler.getInstance().addNewOrderToQueue(cakeType);// Lägger till beställning i beställningskö, och VD får en notis om beställning.
			buildTheCake(cakeType, customer);
		}
	}
	
	public void buildTheCake(String cakeType, Customer customer) { 

		CakeOrderHandler.getInstance().pollOrderedCakeFromQueue(); // Tårtan pollas ifrån beställningkön.
		wait(1500);
		
		if(cakeType.equals("Princess")) {
			PrincessCakeBuilder builder = new PrincessCakeBuilder(); // Tårtans grund byggs i Builder.
			Cake cake = builder
					.addName()
					.addFirstCakeBottom()
					.addFirstCream()
					.addSecondCakeBottom()
					.addSecondCream()
					.addThirdCakeBottom()
					.addId(generateNewId())
					.addToppings()
					.build();
			CakeDecoratingPipeline processingPipeline = new CakeDecoratingPipeline(); // Tårtan görs klar med Command.
			processingPipeline.addCommand(new AddWhippedCreamCommand());
			processingPipeline.addCommand(new AddGreenMarzipanCommand());
			processingPipeline.addCommand(new AddRoseCommand());
			processingPipeline.execute();
			wait(1500);

			customer.addCake(cake.getiD(), cake); // Lägger till Tårt-id och Tårtan i kundens egen lista.
			CakeOrderHandler.getInstance().addCakeToDeliveredList(cake); // Tårtan läggs till i lista över färdiga/levererade tårtor. VD får en notis om att tårtan är klar.
		}
		
		else if(cakeType.equals("Opera")) {
			OperaCakeBuilder builder = new OperaCakeBuilder();
			Cake cake = builder
					.addName()
					.addFirstCakeBottom()
					.addFirstCream()
					.addSecondCakeBottom()
					.addSecondCream()
					.addThirdCakeBottom()
					.addId(generateNewId())
					.addToppings()
					.build();
			CakeDecoratingPipeline processingPipeline = new CakeDecoratingPipeline();
			processingPipeline.addCommand(new AddWhippedCreamCommand());
			processingPipeline.addCommand(new AddPinkMarzipanCommand());
			processingPipeline.addCommand(new AddRoseCommand());
			processingPipeline.execute();
			wait(1500);

			customer.addCake(cake.getiD(), cake);
			CakeOrderHandler.getInstance().addCakeToDeliveredList(cake);
		}
		
		else if(cakeType.equals("Choklad")) {
			ChocolateCakeBuilder builder = new ChocolateCakeBuilder();
			Cake cake = builder
					.addName()
					.addFirstCakeBottom()
					.addFirstCream()
					.addSecondCakeBottom()
					.addSecondCream()
					.addThirdCakeBottom()
					.addId(generateNewId())
					.addToppings()
					.build();
			CakeDecoratingPipeline processingPipeline = new CakeDecoratingPipeline();
			processingPipeline.addCommand(new AddChocolateCreamCommand());
			processingPipeline.addCommand(new AddChocolateGanashCommand());
			processingPipeline.addCommand(new AddRaspberryCommand());
			processingPipeline.execute();
			wait(1500);

			customer.addCake(cake.getiD(), cake);
			CakeOrderHandler.getInstance().addCakeToDeliveredList(cake);
		}
		
	}
	
	public Customer customerLogIn() { // Logga in befintlig kund med hjälp av id/kundnummer.
		Customer customer = null;
		System.out.println("Ange ditt ID/Kundnummer: ");
		String StrId = sc.nextLine();
		try {
			int id = Integer.parseInt(StrId);
			for(Customer c : VD.getInstance().getCustomerList()) { // Söker igenom VD'ns kundregister. 
				if(c.getiD() == id) {
					customer = c; // om träff, returnera kunden. Annars null. 
				}
			}
			System.out.println("Välkommen "+customer.getName());
		}
		catch(NumberFormatException | NullPointerException e) {
			System.out.println("Vänligen skriv in ett giltigt ID / Kundnummer.");
		}
		return customer;
	}
	
	public Customer newCustomer() { // Skapar ett nytt Customer-objekt. Med fler Customer-attribut skulle man även kunnat verifiera att kunden redan inte existerar. dvs undvika multipla kontot för samma kund.
		int iD = generateNewId();
		
		System.out.println("Skriv in kundens namn:");
		String name = sc.nextLine();
		
		System.out.println("Ny kund registrerad\n"
				+ "Namn: "+name+"\n"
				+ "Kundens ID: "+iD+"\n");
		
		Customer customer = new Customer(name, iD); // Skapa customer
		VD.getInstance().addCustomerToList(customer); // Lägg till i kundregister.
		
		return customer;
	}

	public int generateNewId() { // slumpar fram oh returnerar ett unikt id mellan 1000 och 9999.
		Random random = new Random();
		int id = random.nextInt(9000)+1000;
		
		for(Customer c : VD.getInstance().getCustomerList()){
			if(c.getiD() == id) {
				return generateNewId();
			}
		}
		return id;
	}
	
	public void orderHistory(Customer customer) {
		
		System.out.println("Kund: "+customer.getName());
			for(Map.Entry<Integer, Cake> entry : customer.getCakes().entrySet()) { // Loopar igenom alla objekt i kundens Map<Tårtid, Cake>
			System.out.println("Tårt-id: " + entry.getKey() + ", Tårttyp: "+ entry.getValue().getName()); // Skriver ut tårtid och tårtans namn.
		}
	}

	public void wait(int ms) // Metod för att skapa fördröjning i programmet mellan vissa utskrifter
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ie)
		{
			Thread.currentThread().interrupt();
		}
	}
}
