package petcare;

public class Animal {
    // Write your implemetation here
    
    private String name;
    private AnimalSize size;
    private int comfortTemperatureLow;
    private int comfortTemperatureHigh;

    public Animal(String name, AnimalSize size, int comfortTemperatureLow, int comfortTemperatureHigh) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long.");
        }
        if (comfortTemperatureLow < 0 || comfortTemperatureHigh > 50 || comfortTemperatureLow > comfortTemperatureHigh) {
            throw new IllegalArgumentException("Invalid temperature range.");
        }

        this.name = name;
        this.size = size;
        this.comfortTemperatureLow = comfortTemperatureLow;
        this.comfortTemperatureHigh = comfortTemperatureHigh;
    }

    // Getters
    public String getName() {
        return name;
    }

    public AnimalSize getSize() {
        return size;
    }

    public int getComfortTemperatureLow() {
        return comfortTemperatureLow;
    }

    public int getComfortTemperatureHigh() {
        return comfortTemperatureHigh;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long.");
        }
        this.name = name;
    }

    public void setComfortTemperatureRange(int low, int high) {
        if (low < 0 || high > 50 || low > high) {
            throw new IllegalArgumentException("Invalid temperature range.");
        }
        this.comfortTemperatureLow = low;
        this.comfortTemperatureHigh = high;
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', size=" + size + ", temperatureRange=[" + comfortTemperatureLow + ", " + comfortTemperatureHigh + "]}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return name.equals(animal.name) && size == animal.size;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + size.hashCode();
    }
}

