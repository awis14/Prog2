/**
 * 
 */
package Subway;

import java.util.ArrayList;

/**
 * @author David
 *
 */
public class Passenger {
	private int destination;
	private boolean hurry;
	
	public Passenger(int stationNumber) {
		destination = (int) (stationNumber+1 + (int)(Math.random() * ((9 - stationNumber+1) + 1)));
		int rand = (int)(1 + (int)(Math.random() * ((3 - 1) + 1)));
		if(rand == 3){
			this.hurry = true;
		}
		else {
			this.hurry = false;
		}
	}
	
	public Passenger getIn(Wagon wagon, Station station) {
		if(wagon.spaceLeft()) {
			wagon.passengerIn(this);
			station.passengerOut(this);
			return this;
		}
		else{
			return null;
		}
	}
	
	public Passenger getOut(int station, Wagon wagon) {
		if(station == this.destination) {
			wagon.passengerOut(this);
			return this;
		}
		return null;
	}
	
	public boolean isInAHurry() {
		return this.hurry;
	}
	public int getsOutAt() {
		return this.destination;
	}
}
