class Rabbit extends Animal {
    public Rabbit(Field field, Location location) {
        super(field, location);
    }

    @Override
    public void act() {
        if (isAlive()) {
            move();
        }
    }
}
