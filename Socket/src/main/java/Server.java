import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("Server is ready, port 8081");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Hello");
            String response = in.readLine();
            System.out.println("Client: " + response);

            boolean russianLetters = false;
            for (char ru : response.toCharArray()) {
                {
                    russianLetters = true;
                    break;
                }
            }

            if (russianLetters) {

                out.println("Що таке паляниця?");
                response = in.readLine();
                System.out.println("Client: " + response);

                if (response.equalsIgnoreCase("---")) {
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    out.println("Current date and time: " + now.format(formatter));
                    out.println("Goodbye");
                } else {
                    out.println("Incorrect answer. Goodbye.");
                    clientSocket.close();
                }
            } else {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                out.println("Current date and time: " + now.format(formatter));
                out.println("Goodbye");
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
    }
}
