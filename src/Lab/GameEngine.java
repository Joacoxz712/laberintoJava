package Lab;

public class GameEngine {
    private final Player player;
    private final Event events;
    private final UI ui;
    private final int exitDistance;

    public GameEngine(Player player, Event events, UI ui, int exitDistance) {
        this.player = player;
        this.events = events;
        this.ui = ui;
        this.exitDistance = exitDistance;
    }

    public void run() {
        ui.showHeader();
        boolean running = true;

        while (running && player.isAlive() && !hasReachedExit()) {
            ui.showStatus(player, exitDistance);
            ui.showMenu();

            switch (ui.readOption()) {
                case 1 -> {
                    player.move();
                    Event.EventFunc e = events.rollMovementEvent();
                    if (e.energyDelta() > 0) player.heal(e.energyDelta());
                    else player.penalize(-e.energyDelta());
                    System.out.println(e.message());
                }
                case 2 -> { player.turn(); System.out.println("Giraste a la izquierda.");}
                case 3 -> { player.turn(); System.out.println("Giraste a la derecha.");}
                case 4 -> { player.rest(); System.out.println("Descansaste. +3 energia, -1 paso.");}
                case 5 -> running = false;
                default -> { player.penalize(1); System.out.println("Opcion invalida. -1 energia.");}
            }
        }

        ui.showResult(player, hasReachedExit());
        ui.close();
    }

    public boolean hasReachedExit() {
        return player.getSteps() >= exitDistance;
    }

    static void main() {
        new GameEngine(
                new Player(),
                new Event(),
                new UI(),
                5
        ).run();
    }
}