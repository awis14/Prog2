package mypack;

import java.util.ArrayList;

/**
 * @author David
 * 
 */

public class Wagon {
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	/**
	 * @param passenger
	 */
	public void passengerIn(Passenger passenger) {
		passengers.add(passenger);
	}
	
	/**
	 * @param passenger
	 */
	public void passengerOut(Passenger passenger){
		passengers.remove(passenger);
	}
	
	/**
	 * @return
	 */
	public boolean spaceLeft() {
		if(this.passengers.size() < 30) {
			return true;
		}
		else {
			return false;
		}			
	}
	
	/**
	 * @return
	 */
	public int passengerCount() {
		return this.passengers.size();
	}
	
	/**
	 * @return
	 */
	public int passengerInAHurryCount() {
		int counter = 0;
		for (int i = 0 ; i < this.passengers.size() ; i++) {
			if(this.passengers.get(i).isInAHurry()) {
				counter++;
			}
		}
		return counter;
	}
	
	
	/**
	 * @param i
	 * @return
	 */
	public Passenger getPassenger(int i) {
		return this.passengers.get(i);
	}
	
}
