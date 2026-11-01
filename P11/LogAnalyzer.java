package P11;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.util.stream.Stream;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {

        Path folder = Paths.get("logs");
        Files.createDirectories(folder);

        Files.write(folder.resolve("log1.txt"),
                ("Application started\nError found\nUser logged in\n")
                .getBytes());

        Files.write(folder.resolve("log2.txt"),
                ("Warning detected\nError found again\nApplication closed\n")
                .getBytes());

        String keyword = "Error";
        int totalLines = 0;
        int keywordCount = 0;

        try (Stream<Path> files = Files.list(folder)) {
            for (Path file : (Iterable<Path>) files::iterator) {
                if (Files.isRegularFile(file)) {

                    BasicFileAttributes attributes =
                            Files.readAttributes(file, BasicFileAttributes.class);

                    int fileLines = 0;

                    try (Stream<String> lines = Files.lines(file)) {
                        for (String line : (Iterable<String>) lines::iterator) {
                            totalLines++;
                            fileLines++;

                            if (line.contains(keyword)) {
                                keywordCount++;
                            }
                        }
                    }

                    System.out.println("File: " + file.getFileName());
                    System.out.println("Size: " + attributes.size() + " bytes");
                    System.out.println("Lines: " + fileLines);
                    System.out.println();
                }
            }
        }

        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing '" + keyword + "': " + keywordCount);
    }
}
