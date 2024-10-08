import java.util.Scanner;

public class InputReader {
    private Scanner scan;

    public InputReader(){
        scan = new Scanner(System.in);
    }

    public String GetScan(){
        System.out.print("> ");
        return scan.nextLine();
    }
}
