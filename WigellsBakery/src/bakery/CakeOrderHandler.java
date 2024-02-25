package bakery;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import businessObjects.Cake;

//Då det bara skall finnas en beställningskö och en lista med levererade tårtor så är denna klass Singleton.
public class CakeOrderHandler {

	private Queue<String> orderedCakes;
	private List<Cake> deliveredCakes;
	
	private PropertyChangeSupport propertyChangeSupport;
	
	private static CakeOrderHandler instance;
	
	private CakeOrderHandler() {
		propertyChangeSupport = new PropertyChangeSupport(this);
		orderedCakes = new ConcurrentLinkedQueue<>();
		deliveredCakes = new ArrayList<>();
	} 
	
	public synchronized static CakeOrderHandler getInstance() {
		if(instance == null) {
			instance = new CakeOrderHandler();
		}
		return instance;
	}
	
	public synchronized void addCakeToDeliveredList(Cake cake) {
		Cake previousLastCake = getLastDeliveredCake();
		this.deliveredCakes.add(cake);
		Cake newLastCake = getLastDeliveredCake();
		if (!newLastCake.equals(previousLastCake)) {
            propertyChangeSupport.firePropertyChange("cakeQueue", previousLastCake, newLastCake);
        }
	}
	
	public synchronized void addNewOrderToQueue(String type) {
		
		String previousLastCake = getLastOrderedCake();
		this.orderedCakes.add(type);
		String newLastCake = getLastOrderedCake();
		if (!newLastCake.equals(previousLastCake)) {
            propertyChangeSupport.firePropertyChange("orderedCakes", previousLastCake, newLastCake);
        }
	}
	
	public synchronized String pollOrderedCakeFromQueue() {
		return orderedCakes.poll();
		
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.propertyChangeSupport.addPropertyChangeListener(listener);
	}
	
	private Cake getLastDeliveredCake() { // returnerar den sista tårtan i kön.
		
	    if (!this.deliveredCakes.isEmpty()) {
	        return this.deliveredCakes.get(this.deliveredCakes.size() - 1);
	    }
	    return null;
    }
	
	private synchronized String getLastOrderedCake() {
        List<String> cakeList = new ArrayList<>(orderedCakes);

        if (!cakeList.isEmpty()) {
            return cakeList.get(cakeList.size() - 1);
        }
        return null;
    }

	public Queue<String> getOrderedCakes() {
		return orderedCakes;
	}

	public synchronized void setOrderedCakes(Queue<String> orderedCakes) {
		this.orderedCakes = orderedCakes;
	}

	public List<Cake> getDeliveredCakes() {
		return deliveredCakes;
	}

	public synchronized void setDeliveredCakes(List<Cake> deliveredCakes) {
		this.deliveredCakes = deliveredCakes;
	}
	
}
