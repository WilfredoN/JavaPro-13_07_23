package io;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FileLoggerTest {
    private final FileLoggerConfiguration config = new FileLoggerConfiguration(
            "./logs/",
            512,
            "hillel_",
            LoggingLevel.DEBUG
    );
    private final FileLogger logger = new FileLogger(config);

    @Test
    void testLogger() throws FileSizeLimitExceededException {
        logger.debug("Hello World!");
        assertEquals("./logs/", config.getFilePath());
        File[] logFiles = new File(config.getFilePath()).listFiles();
        assert logFiles != null;
        assertNotEquals(0, logFiles.length);
        for (int i = 0; i < 30; i++) logger.debug("My Message");
        for (File logFile : logFiles) {
            logFile.deleteOnExit();
        }
    }
}
