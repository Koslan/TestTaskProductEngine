
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to root repository");
        String rootPath = scanner.nextLine();

        System.out.println("Enter search mask");
        String mask = scanner.nextLine();

        System.out.println("Enter search depth");
        int depth = scanner.nextInt();

        Path testFilePath = Paths.get(rootPath);
        try {
            Files
                    .walk(testFilePath, depth)
                    .map(name -> name.getFileName().toString())
                    .filter(name -> !name.isEmpty() && name.contains(mask))
                    .forEach(System.out :: println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
