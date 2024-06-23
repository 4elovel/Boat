import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Peer {

    private final ArrayList<Boat> boats = new ArrayList<>();
    private final Queue<Passenger> passengers = new ArrayDeque<>();
    private Duration totalWaitingTime = Duration.ZERO;
    private int passengerHandledCount = 0;

    public void addPassenger(Passenger passenger) {
        passengers.offer(passenger);
    }

    public void addBoat(Boat boat) {
        boats.add(boat);
    }

    public void prepareBoat(Boat boat) {
        if (!boat.getTerminal()) {
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            BoatDepartation(boat);
                        }
                    },
                    boat.getWaitingTime().toMillis()
            );
        }
    }

    public void BoatDepartation(Boat boat) {
        int maxCapacity = boat.getCapacity();
        int count = 0;
        for (int i = 0; i < maxCapacity; i++) {
            Passenger passenger = passengers.poll();
            if (passenger != null) {
                count++;
                totalWaitingTime = totalWaitingTime.plus(
                        Duration.between(passenger.getArrivalTime(), LocalDateTime.now()));
                passengerHandledCount++;
                continue;
            }
            boats.remove(boat);
            return;
        }
    }

    public String getAverageWaitingTime() {
        DecimalFormat decfor = new DecimalFormat("0.00");
        return passengerHandledCount == 0 ? "0"
                : decfor.format((double) totalWaitingTime.toSeconds() / passengerHandledCount);
    }
}
