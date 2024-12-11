package petcare;

import java.util.ArrayList;
import java.util.List;

public class PetService {
    private List<Enclosure> enclosures;

    public PetService() {
        this.enclosures = new ArrayList<>();
    }

    public void addEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
    }

    public void printAllEnclosures() {
        for (Enclosure enclosure : enclosures) {
            System.out.println(enclosure);
        }
    }

    public boolean allocateAnimal(Animal animal) {
        Enclosure bestEnclosure = null;
        for (Enclosure enclosure : enclosures) {
            if (enclosure.checkCompatibility(animal) && enclosure.getOccupant() == null) {
                if (bestEnclosure == null || enclosure.getRunningCosts() < bestEnclosure.getRunningCosts()) {
                    bestEnclosure = enclosure;
                }
            }
        }
        if (bestEnclosure != null) {
            bestEnclosure.addAnimal(animal);
            return true;
        }
        return false;
    }

    public void removeAnimal(Animal animal) {
        for (Enclosure enclosure : enclosures) {
            if (animal.equals(enclosure.getOccupant())) {
                enclosure.removeAnimal();
                return;
            }
        }
        throw new IllegalArgumentException("Animal not found in any enclosure.");
    }
}