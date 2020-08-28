import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO Read the file into a list<string>
        List<String> lines = new List<String>();
        lines = Files.readAllLines(args[0]);
        


        // TODO File Validation
        // TODO Get number of simulations
        // TODO Create weathertower
        // TODO Create the aircraft and register them to the tower
        // TODO Run simulations
    }
}