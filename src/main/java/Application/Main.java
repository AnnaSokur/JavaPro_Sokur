package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String exitCmd = "exit";
    private static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        BookParser bookParser = new BookParser();
        Scanner scanner = new Scanner(System.in);
        BookStatSeria bookStatSeria = new BookStatSeria();
        System.out.print("Input name of the book: ");
        String bookName = scanner.nextLine();
        Path bookPath = Paths.get("src/main/resources", bookName);

            while (!scanner.next().equals(exitCmd)) {
                System.out.println("Please enter the book " + exitCmd);
                File book = new File(PATH + scanner.next());
                List<String> words = bookParser.getText(book);
                List<String> topWords = bookParser.topWords(words, 3);
                int uniqWords = bookParser.uniqWords(words);
                BookStat bookStat = new BookStat(topWords, uniqWords);
                System.out.println(bookStat);
                bookStatSeria.serialize(bookStat, new File(PATH + book.getName() + "_statistic.txt"));


                if (!Files.exists(bookPath)) {
                    System.out.println("The book did not find.");
                    return;

            }

            scanner.close();


        }
    }
}
