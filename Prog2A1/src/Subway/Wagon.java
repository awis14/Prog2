/**
 * 
 */
package Subway;

import java.util.ArrayList;

/**
 * @author David
 * 
 */
public class Wagon {
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	public void passengerIn(Passenger passenger) {
		passengers.add(passenger);
	}
	
	public void passengerOut(Passenger passenger){
		passengers.remove(passenger);
	}
	
	public boolean spaceLeft() {
		if(this.passengers.size() < 30) {
			return true;
		}
		else {
			return false;
		}			
	}
	
	public int passengerCount() {
		return this.passengers.size();
	}
	
	public int passengerInAHurryCount() {
		int counter = 0;
		for (int i = 0 ; i < this.passengers.size() ; i++) {
			if(this.passengers.get(i).isInAHurry()) {
				counter++;
			}
		}
		return counter;
	}
	
	
	public Passenger getPassenger(int i) {
		return this.passengers.get(i);
	}
	
}
