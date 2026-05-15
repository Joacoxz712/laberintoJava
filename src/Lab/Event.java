package Lab;

import java.util.Random;

public class Event {
    private final Random rng = new Random();

    public record EventFunc(String message, int energyDelta) {}

    public EventFunc rollMovementEvent() {
        return switch (rng.nextInt(3)) {
          case 0 -> new EventFunc("Encontraste una pocion! +5 energia.", +5);
          case 1 -> new EventFunc("Caiste en una trampa! -5 energia extra.", -5);
            default ->  new EventFunc("Avanzaste.", 0);
        };
    }
}
