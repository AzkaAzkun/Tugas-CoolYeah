import java.util.ArrayList;
import java.util.List;

public class Simulation {
    protected static List<Animal> animals = new ArrayList<>(); // Daftar hewan di simulasi
    private Field field;

    public Simulation(int width, int height) {
        field = new Field(width, height);

        for (int i = 0; i < 5; i++) {
            animals.add(new Rabbit(field, new Location(i, i)));
            animals.add(new Fox(field, new Location(width - i - 1, height - i - 1)));
        }
    }

    public void simulateStep() {
        for (Animal animal : new ArrayList<>(animals)) { // Iterasi pada salinan daftar
            if (animal.isAlive()) {
                animal.act();
            }
        }

        animals.removeIf(animal -> !animal.isAlive() && animal instanceof Rabbit);

        long rabbitsLeft = animals.stream().filter(a -> a instanceof Rabbit).count();
        System.out.println("Rabbits remaining: " + rabbitsLeft);
    }

    public static void main(String[] args) {
        Simulation sim = new Simulation(3, 3);
        for (int step = 0; step < 10; step++) {
            System.out.println("\nStep " + step + ":");
            sim.simulateStep();
        }
    }
}
