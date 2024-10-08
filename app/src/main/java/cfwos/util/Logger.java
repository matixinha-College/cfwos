package cfwos.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private BufferedWriter writer;
    private DateTimeFormatter formatter;

    // Constructor initializes the logger with the given filename
    public Logger(String filename) {
        try {
            writer = new BufferedWriter(new FileWriter(filename, false));
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    // Log a message with a timestamp
    public void log(String message) {
        try {
            String timestamp = LocalDateTime.now().format(formatter);
            writer.write("[" + timestamp + "] " + message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    // Log a message with a specified level (INFO, WARNING, ERROR)
    public void log(String level, String message) {
        try {
            String timestamp = LocalDateTime.now().format(formatter);
            writer.write("[" + timestamp + "] [" + level + "] " + message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    // Close the BufferedWriter
    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing log file: " + e.getMessage());
        }
    }
}
