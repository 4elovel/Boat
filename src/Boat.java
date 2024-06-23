import java.time.Duration;
import java.time.LocalDateTime;

public class Boat {

    private Boolean іsTerminal;
    private Duration waitingTime;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private int capacity;

    public Boat(int capacity, Duration waitingTime,
            Boolean іsTerminal) {
        this.arrivalTime = LocalDateTime.now();
        this.capacity = capacity;
        this.waitingTime = waitingTime;
        this.іsTerminal = іsTerminal;
        this.departureTime = arrivalTime.plus(waitingTime);
    }

    public Duration getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Duration waitingTime) {
        this.waitingTime = waitingTime;
    }

    public Boolean getTerminal() {
        return іsTerminal;
    }

    public void setTerminal(Boolean terminal) {
        іsTerminal = terminal;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}
