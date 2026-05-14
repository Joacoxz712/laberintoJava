package Lab;

public class Main {
    static void main() {
        new GameEngine(
                new Player(),
                new Maze(5),
                new Event(),
                new UI()
        ).run();
    }
}
