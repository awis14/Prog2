/**
 * 
 */
package Subway;

import java.util.ArrayList;

/**
 * @author David
 *
 */
public class Station {
	
	private ArrayList<Passenger> waiting = new ArrayList<Passenger>();
	private int stationNumber;
	
	public Station(int stationNumber) {
		this.stationNumber = stationNumber;
		int rand = (20 + (int)(Math.random() * ((75 - 20) + 1)));
		for(int i = 0 ; i <= rand ; i++) {
			this.waiting.add(new Passenger(stationNumber));
		}	
	}
	
	public void passengerOut(Passenger passenger){
		waiting.remove(passenger);
	}
	
	public ArrayList<Passenger> waitingAt() {
		return waiting;	
	}
	
}
