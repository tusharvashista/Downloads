package petcare;

public class Enclosure {
    private AnimalSize size;
    private int temperature;
    private int runningCosts;
    private Animal occupant;

    public Enclosure(AnimalSize size, int temperature, int runningCosts) {
        this.size = size;
        this.temperature = temperature;
        this.runningCosts = runningCosts;
        this.occupant = null;
    }

    // Getters
    public AnimalSize getSize() {
        return size;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getRunningCosts() {
        return runningCosts;
    }

    public Animal getOccupant() {
        return occupant;
    }

    // Compatibility check
    public boolean checkCompatibility(Animal animal) {
        return animal.getSize().ordinal() <= size.ordinal() &&
                temperature >= animal.getComfortTemperatureLow() &&
                temperature <= animal.getComfortTemperatureHigh();
    }

    public void addAnimal(Animal animal) {
        if (!checkCompatibility(animal) || occupant != null) {
            throw new IllegalArgumentException("Cannot add animal to enclosure.");
        }
        this.occupant = animal;
    }

    public void removeAnimal() {
        this.occupant = null;
    }

    @Override
    public String toString() {
        return "Enclosure{size=" + size + ", temperature=" + temperature + ", runningCosts=" + runningCosts
                + ", occupant=" + (occupant != null ? occupant : "None") + "}";
    }
}