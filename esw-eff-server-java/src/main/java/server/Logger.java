package server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static boolean debug = true;
    public static void log(String message) {
        if (!debug) {
            return;
        }
        String now = "[" +
                LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"))
                + "] ";
        System.out.println(now + message);
    }

    public static void log_ALW(String message) {
        String now = "[" +
                LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"))
                + "] ";
        System.out.println(now + message);
    }

}