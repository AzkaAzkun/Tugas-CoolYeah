public class Game {
    private Parser parser;
    private Room currentRoom;

    public Game() {
        setupRooms();
        parser = new Parser();
    }

    private void setupRooms() {
        Room outside = new Room("outside the main entrance of the university");
        Room theater = new Room("in a lecture theater");
        Room pub = new Room("in the campus pub");
        Room lab = new Room("in a computing lab");
        Room office = new Room("in the office");

        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Goodbye!");
    }

    private void printWelcome() {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a simple adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printRoomDetails();
    }

    private void printRoomDetails() {
        System.out.println("You are " + currentRoom.getDescription());
        System.out.println(currentRoom.getExitString());
    }

    private boolean processCommand(Command command) {
        String commandWord = command.getCommandWord();

        if (commandWord == null) {
            System.out.println("I don't understand that command...");
            return false;
        }

        switch (commandWord) {
            case "help":
                printHelp();
                break;
            case "go":
                goRoom(command);
                break;
            case "quit":
                return quit(command);
            default:
                System.out.println("I don't understand that command...");
        }
        return false;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander around at the university.");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            printRoomDetails();
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
