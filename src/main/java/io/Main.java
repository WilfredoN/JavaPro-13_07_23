package io;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FileSizeLimitExceededException {
        var config = new FileLoggerConfiguration(
                "./src/main/logs/",
                512,
                "hillel_",
                LoggingLevel.INFO
        );
        var fileLogger = new FileLogger(config);
        for (int i = 0; i < 30; i++) {
            fileLogger.debug("My Debug Message");
            fileLogger.info("My info message");
        }
    }
}
