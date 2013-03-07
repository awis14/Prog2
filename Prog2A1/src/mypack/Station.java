/**
 * 
 */
package mypack;

import java.util.ArrayList;

/**
 * @author David
 *
 */
public class Station {
	
	private ArrayList<Passenger> waiting = new ArrayList<Passenger>();
	private int stationNumber;
	
	/**
	 * @param stationNumber
	 */
	public Station(int stationNumber) {
		this.stationNumber = stationNumber;
		int rand = (20 + (int)(Math.random() * ((75 - 20) + 1)));
		for(int i = 0 ; i <= rand ; i++) {
			this.waiting.add(new Passenger(stationNumber));
		}	
	}
	
	/**
	 * @param passenger
	 */
	public void passengerOut(Passenger passenger){
		waiting.remove(passenger);
	}
	
	/**
	 * @return
	 */
	public ArrayList<Passenger> waitingAt() {
		return waiting;	
	}
	
	/**
	 * @param i
	 * @return
	 */
	public String getStationName() {
		switch(this.stationNumber) {
		case 0:
			return "Rathaus Stieglitz";
		case 1:
			return "Schloßstraße";
		case 2:
			return "Walter-Schreiber-Platz";
		case 3:
			return "Friedrich-Wilhelm-Platz";
		case 4:
			return "Bundesplatz";
		case 5:
			return "Berliner Straße";
		case 6:
			return "Güntzelstraße";
		case 7:
			return "Spichernstraße";
		case 8:
			return "Kurfürstendamm";
		case 9:
			return "Zoologischer Garten";
		default:
			return "";
		}
	}
	
}
