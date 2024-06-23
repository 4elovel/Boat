import java.time.LocalDateTime;

public class Passenger {

    private final LocalDateTime arrivalTime;

    Passenger(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
}
