public abstract class Animal {
    protected Location location;
    protected Field field;
    protected boolean alive = true;

    public Animal(Field field, Location location) {
        this.field = field;
        this.location = location;
        field.place(this, location);
    }

    public void move() {
        Location newLoc = field.randomAdjacent(location);
        field.move(location, newLoc);
        location = newLoc;
    }

    public abstract void act();
    public boolean isAlive() { return alive; }
    public void die() { alive = false; }
}
