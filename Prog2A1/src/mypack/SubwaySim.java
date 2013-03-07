/**
 * 
 */
package mypack;

import java.util.ArrayList;

/**
 * @author David
 * 
 */
public class SubwaySim {
	public static void main(String[] args) {
		// The Train
		ArrayList<Wagon> train = new ArrayList<Wagon>();
		//The Track
		ArrayList<Station> track = new ArrayList<Station>();
		//A Train consists of 3-8 Wagons
		int rand = (3 + (int) (Math.random() * ((8 - 3) + 1)));
		for (int wagonIter = 0; wagonIter <= rand - 1; wagonIter++) {
			train.add(new Wagon());
		}
		//A Track consists of 9 Stations
		for (int stationIter = 0; stationIter < 10; stationIter++) {
			track.add(new Station(stationIter));
		}
		System.out.print("Sehr geehrter Fahrgäste, dieser Zug hat ");
		System.out.print(train.size());
		System.out.println(" Wagons!");
		
		//iterate over all Stations on the Track
		for (int trackIter = 0; trackIter < track.size() ; trackIter++) {
			Station station = track.get(trackIter);
			ArrayList<Passenger> gotOut = new ArrayList<Passenger>();
			int hurryOut = 0;
			System.out.print("---");
			System.out.print(track.get(trackIter).getStationName());
			System.out.println("---");
			System.out.print("Wartende: ");
			System.out.println(station.waitingAt().size());
			//iterate over all Wagons of the Train
			for (int trainIter = 0; trainIter < train.size() - 1; trainIter++) {
				//iterate over all Passengers in a Wagon
				for (int passangerIter = 0; passangerIter < train.get(trainIter).passengerCount(); passangerIter++) {
					Passenger leavingPassenger = train.get(trainIter).getPassenger(passangerIter)
							.getOut(trackIter, train.get(trainIter));
					//if the leavingPassenger is at the right station
					if (leavingPassenger != null) {
						gotOut.add(leavingPassenger);
						if (passangerIter > 0) {
							passangerIter--;
						} else {
							passangerIter = 0;
						}
						if (train.get(trainIter).getPassenger(passangerIter).isInAHurry()) {
							hurryOut++;
						}
					}
				}
			}
			//output
			System.out.print("Passagiere ausgestiegen: ");
			System.out.print(gotOut.size());
			System.out.print(", davon ");
			System.out.print(hurryOut);
			System.out.println(" in Eile.");

			//The lucky ones who got in
			ArrayList<Passenger> gotIn = new ArrayList<Passenger>();
			int hurryIn = 0;
			//iterte over all waiting People at the Station
			for (int waitingIter = 0; waitingIter < ((station.waitingAt().size())); waitingIter++) {
				//All waiting passengers try to get into a random wagon
				Passenger schroedingersPassenger = station
						.waitingAt()
						.get(waitingIter)
						.getIn(train.get((int) (0 + (int) (Math.random() * ((train
								.size() - 1 - 0) + 1)))), track.get(trackIter));
				// If it worked, add Passenger to gotIn List
				if (schroedingersPassenger != null) {
					gotIn.add(schroedingersPassenger);
					waitingIter--;
					if (schroedingersPassenger.isInAHurry()) {
						hurryIn++;
					} else {
						// /nothingsness
					}
				} else {
					//If the passenger did not get in, but it in a hurry...
					if (station.waitingAt().get(waitingIter).isInAHurry()) {
						//iterate over all Wagons of the train
						for (int i = 0; i < train.size() - 1; i++) {
							Passenger schroedingersPassengerInAHurry = station
									.waitingAt().get(waitingIter)
									.getIn(train.get(i), track.get(trackIter));
							//and finally, if the passenger who is in a hurry managed to get into a wagon...
							if (schroedingersPassengerInAHurry != null) {
								gotIn.add(schroedingersPassengerInAHurry);
								waitingIter--;
								hurryIn++;
								break;
							}
						}
					}
				}
			}

			int hurryStay = 0;
			//iterate over all passengers who did not get in...
			for (int i = 0; i < track.get(trackIter).waitingAt().size(); i++) {
				//...and increment the hurryStay counter if there are passengers in a hurry that did not get in
				if (track.get(trackIter).waitingAt().get(i).isInAHurry()) {
					hurryStay++;
				}
			}
			//output
			System.out.print("Passagiere eingestiegen: ");
			System.out.print(gotIn.size());
			System.out.print(", davon ");
			System.out.print(hurryIn);
			System.out.println(" in Eile.");

			System.out.print("Passagiere zurückgelassen: ");
			System.out.print(track.get(trackIter).waitingAt().size());
			System.out.print(", davon ");
			System.out.print(hurryStay);
			System.out.println(" in Eile.");

			int alloverCounter = 0;
			//iterate over all Wagons and output the passenger count
			for (int alloverIter = 0; alloverIter < train.size(); alloverIter++) {
				System.out.print("Wagon ");
				System.out.print(alloverIter);
				System.out.print(": (");
				System.out.print(train.get(alloverIter).passengerCount());
				System.out.println("/30)");

				alloverCounter += train.get(alloverIter).passengerCount();
			}
			System.out.print("Also alles in allem ");
			System.out.print(alloverCounter);
			System.out.println(" Fahrgäste!");
			System.out.println("");
		}
	}
}
