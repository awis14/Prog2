/**
 *
 */
package mypack;

/**
 * @author David
 */
public class Passenger {
    private final int destination;
    private final boolean hurry;

    /**
     * @param stationNumber
     */
    public Passenger(int stationNumber) {
        destination = stationNumber + 1 + (int) (Math.random() * ((9 - stationNumber + 1) + 1));
        int rand = 1 + (int) (Math.random() * ((3 - 1) + 1));
        this.hurry = rand == 3;
    }

    /**
     * @param wagon
     * @param station
     * @return
     */
    public Passenger getIn(Wagon wagon, Station station) {
        if (wagon.spaceLeft()) {
            wagon.passengerIn(this);
            station.passengerOut(this);
            return this;
        } else {
            return null;
        }
    }

    /**
     * @param station
     * @param wagon
     * @return
     */
    public Passenger getOut(int station, Wagon wagon) {
        if (station == this.destination) {
            wagon.passengerOut(this);
            return this;
        }
        return null;
    }

    /**
     * @return
     */
    public boolean isInAHurry() {
        return this.hurry;
    }
}
