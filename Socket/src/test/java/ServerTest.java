import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServerTest {
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 8081;
    private static final String UKRAINIAN_GREETING = "Привіт";
    private static final String RUSSIAN_GREETING = "Здравствуйте";
    private static final String CORRECT_ANSWER_RESPONSE = "Current date and time: ";
    private static final String GOODBYE_RESPONSE = "Goodbye";

    private Server thisServer;
    private Socket clientSocket;

    @Test
    public void start() throws IOException {
        thisServer = new Server();
        Thread thread = new Thread((Runnable) thisServer);
        thread.start();

        clientSocket = new Socket(HOSTNAME, PORT);
    }

    @Test
    public void close() throws IOException {
        clientSocket.close();
        thisServer.stop();
    }

    @Test
    public void testUkrainianGreeting() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(UKRAINIAN_GREETING);
        String response = in.readLine();

        assertEquals("Hello", response);

    }

    @Test
    public void testRussianGreeting() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(RUSSIAN_GREETING);
        String response = in.readLine();

        assertEquals("Hello", response);


        response = in.readLine();
        assertEquals("Що таке паляниця?", response);

        assertTrue(response.startsWith(CORRECT_ANSWER_RESPONSE));
        assertTrue(response.endsWith(GOODBYE_RESPONSE));
        out.println(RUSSIAN_GREETING);
        response = in.readLine();

        assertEquals("Hello", response);

        assertEquals("Incorrect answer. Goodbye.", response);
    }

}
