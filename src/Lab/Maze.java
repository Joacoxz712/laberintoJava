package Lab;

public class Maze {
    private final int exitDistance;

    public Maze(int exitDistance) {
        this.exitDistance = exitDistance;
    }

    public boolean hasReachedExit(Player plr) {
        return plr.getSteps() >= exitDistance;
    }

    public int getExitDistance() {return exitDistance;}
}
