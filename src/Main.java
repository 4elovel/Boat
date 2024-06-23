import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();

        int counter = 0;
        int passengerIterator = 1;
        int boatIterator = 1;

        Duration simulationDuration = Duration.ofMinutes(1);
        Duration passengerArrivalInterval = Duration.ofSeconds(1);
        Duration boatArrivalInterval = Duration.ofSeconds(3);

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime endTime = currentTime.plus(simulationDuration);

        Peer peer = new Peer();

        while (currentTime.isBefore(endTime)) {

            if (passengerArrivalInterval.getSeconds() >= passengerIterator) {
                peer.addPassenger(new Passenger(currentTime));
                passengerIterator = 0;
            } else {
                passengerIterator++;
            }

            if (boatArrivalInterval.getSeconds() >= boatIterator) {
                Boat boat = new Boat(rand.nextInt(12) + 1,
                        Duration.ofSeconds(rand.nextInt(5) + 1), rand.nextBoolean());
                peer.addBoat(boat);
                peer.prepareBoat(boat);
                boatIterator = 0;
            } else {
                boatIterator++;
            }
            Thread.sleep(1000);
            currentTime = LocalDateTime.now();

            counter++;
            System.out.println("Iteration: " + counter);
        }
        System.out.println("Avg waiting time: " + peer.getAverageWaitingTime() + " seconds");
    }
}