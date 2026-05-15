package Lab;

public class Player {
    private static final int MAX_ENERGY = 30;

    private int energy;
    private int steps;

    public Player() {
        this.energy = MAX_ENERGY;
        this.steps = 0;
    }

    public void move() {
        steps++;
        energy = Math.max(0, energy - 5);
    }

    public void turn() {energy -= 2;}

    public void rest() {
        energy = Math.min(energy + 3, MAX_ENERGY);
        if (steps > 0) steps--;
    }

    public void penalize(int amount) {energy -= Math.max(0, energy - amount);}

    public void heal(int amount) {energy = Math.min(energy + amount, MAX_ENERGY);}

    public boolean isAlive() {return energy > 0;}

    public int getEnergy() {return energy;}

    public int getSteps() {return steps;}
}
