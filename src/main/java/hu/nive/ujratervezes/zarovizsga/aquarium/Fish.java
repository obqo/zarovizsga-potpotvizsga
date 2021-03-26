package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {

    private final String name;
    protected int weight;
    private final String color;
    protected boolean memoryLoss;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.memoryLoss = false;

    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    public String status() {
        return name + ", weight: " + weight + ", color: " + color +", short term memory loss: " + memoryLoss;
    }

    public abstract void feed();
}
