import java.util.Scanner;

public class Parser {
    private CommandWords commandWords;
    private Scanner scanner;

    public Parser() {
        commandWords = new CommandWords();
        scanner = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");
        String inputLine = scanner.nextLine();
        String[] words = inputLine.split(" ", 2);
        String commandWord = (words.length > 0) ? words[0] : null;
        String secondWord = (words.length > 1) ? words[1] : null;

        if (commandWords.isCommand(commandWord)) {
            return new Command(commandWord, secondWord);
        } else {
            return new Command(null, secondWord);
        }
    }

    public void showCommands() {
        commandWords.showAll();
    }
}
