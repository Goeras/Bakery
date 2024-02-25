package businessObjects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

// Då det bara skall finnas en vd så är denna klass Singleton. VD-klassen är öven Observer.
public class VD implements PropertyChangeListener{

	private final String name;
	private final int iD;

	private List<Customer> customerList = new ArrayList<>();

	private static VD instance;

	private VD() {
		this.name = "Mr Wigell";
		this.iD = 1;
	} 

	public synchronized static VD getInstance() {
		if(instance == null) {
			instance = new VD();
		}
		return instance;
	}

	public synchronized void addCustomerToList(Customer customer) {
		this.customerList.add(customer);
	}

	// Getters & Setters
	public int getiD() {
		return iD;
	}

	public String getName() {
		return name;
	}

	public synchronized List<Customer> getCustomerList() {
		return customerList;
	}

	public synchronized void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	// Observer-metod
	
	@Override 
	public void propertyChange(PropertyChangeEvent evt) {
		// notifierar vd'n med en utskrift om något läggs till i beställningskön.
		if("orderedCakes".equals(evt.getPropertyName())) {
			System.out.println("\n*" + this.name + "! Ny tårta beställd: " + evt.getNewValue()+"tårta\n");
		}
		// notifierar vd'n när tårtan är klar.
		else if ("cakeQueue".equals(evt.getPropertyName())) {
			System.out.println("\n*" + this.name + "! Tårta färdig: " + evt.getNewValue()+"\n");
		}


	}
}
