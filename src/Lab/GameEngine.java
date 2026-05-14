package Lab;

public class GameEngine {
    private final Player player;
    private final Maze maze;
    private final Event events;
    private final UI ui;

    public GameEngine(Player player, Maze maze, Event events, UI ui) {
        this.player = player;
        this.maze = maze;
        this.events = events;
        this.ui = ui;
    }

    public void run() {
        ui.showHeader();
        boolean running = true;

        while (running && player.isAlive() && !maze.hasReachedExit(player)) {
            ui.showStatus(player, maze);
            ui.showMenu();

            switch (ui.readOption()) {
                case 1 -> {
                    player.move();
                    Event.EventFunc e = events.rollMovementEvent();
                    if (e.energyDelta() > 0) player.heal(e.energyDelta());
                    else player.penalize(-e.energyDelta());
                    System.out.println(e.message());
                }
                case 2 -> { player.turnLeft(); System.out.println("Giraste a la izquierda.");}
                case 3 -> { player.turnRight(); System.out.println("Giraste a la derecha.");}
                case 4 -> { player.rest(); System.out.println("Descansaste. +3 energia, -1 paso.");}
                case 5 -> running = false;
                default -> { player.penalize(1); System.out.println("Opcion invalida. -1 energia.");}
            }
        }

        ui.showResult(player, maze);
        ui.close();
    }
}