class Fox extends Animal {
    public Fox(Field field, Location location) {
        super(field, location);
    }

    @Override
    public void act() {
        if (isAlive()) {
            move(); // Rubah bergerak
            hunt(); // Rubah memangsa kelinci
        }
    }

    private void hunt() {
        for (Animal animal : Simulation.animals) {
            if (animal instanceof Rabbit && animal.isAlive() && animal.location.equals(this.location)) {
                animal.die(); // Memangsa kelinci
                System.out.println("Fox ate a rabbit at (" + location.getX() + ", " + location.getY() + ")");
                break;
            }
        }
    }
}
