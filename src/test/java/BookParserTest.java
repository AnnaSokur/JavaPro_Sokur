import Application.BookParser;
import org.junit.Assert;
import org.junit.Test;

import java.awt.print.Book;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BookParserTest {
    @Test
    public void getTextTest() throws IOException {
        BookParser bookParser = new BookParser();
        File file = new File("src/main/resources/" + "test.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("Hello hello world world macbook macbook iphone iphone winter winter");
        writer.close();
        List<String> words = bookParser.getText(file);

        Assert.assertEquals(10, words.size());
        file.delete();


    }

    @Test
    public void topWordsTest() {
        BookParser bookParser = new BookParser();
        List<String> words = List.of("Monday", "Monday", "Friday", "Wednesday", "Sunday", "Saturday", "Friday", "April", "March");
        int amount = 3;
        List<String> expected = List.of("Monday", "Friday", "Wednesday");
        List<String> result = bookParser.topWords(words, amount);
        Assert.assertEquals(expected,result);
    }
    @Test
    public void uniqWords(){
        BookParser bookParser = new BookParser();
        List<String> words = List.of("Monday", "Monday", "Friday", "Wednesday", "Sunday", "Saturday", "Friday", "April", "March");
        int uniqWords = bookParser.uniqWords(words);
        Assert.assertEquals(7,uniqWords);

    }
}
