import java.util.Random;

class Field {
    private int width, height;
    private Animal[][] grid;
    private Random random = new Random();

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Animal[width][height];
    }

    public boolean place(Animal animal, Location loc) {
        if (isInBounds(loc) && grid[loc.getX()][loc.getY()] == null) {
            grid[loc.getX()][loc.getY()] = animal;
            return true;
        }
        return false;
    }

    public void move(Location from, Location to) {
        if (isInBounds(from) && isInBounds(to)) {
            grid[to.getX()][to.getY()] = grid[from.getX()][from.getY()];
            grid[from.getX()][from.getY()] = null;
        }
    }

    public Location randomAdjacent(Location loc) {
        int x = loc.getX() + random.nextInt(3) - 1; // -1, 0, or 1
        int y = loc.getY() + random.nextInt(3) - 1;
        return isInBounds(new Location(x, y)) ? new Location(x, y) : loc;
    }

    private boolean isInBounds(Location loc) {
        return loc.getX() >= 0 && loc.getX() < width && loc.getY() >= 0 && loc.getY() < height;
    }
}
