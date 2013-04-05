package mypack;

import java.util.ArrayList;

/**
 * @author David
 */

class Wagon {
    private final ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    /**
     * @param passenger
     */
    public void passengerIn(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * @param passenger
     */
    public void passengerOut(Passenger passenger) {
        passengers.remove(passenger);
    }

    /**
     * @return
     */
    public boolean spaceLeft() {
        return this.passengers.size() < 30;
    }

    /**
     * @return
     */
    public int passengerCount() {
        return this.passengers.size();
    }


    /**
     * @param i
     * @return
     */
    public Passenger getPassenger(int i) {
        return this.passengers.get(i);
    }

}
