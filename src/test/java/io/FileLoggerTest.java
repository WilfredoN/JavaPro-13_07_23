package io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import static io.FileLoggerConfigurationLoader.load;
import static org.junit.jupiter.api.Assertions.*;

class FileLoggerTest {

    @Test
    void testLogger() throws FileSizeLimitExceededException, IOException {
        FileLoggerConfiguration configuration = new FileLoggerConfiguration("test.log", 1000, "", LoggingLevel.DEBUG);
        assertEquals(configuration, load("test.log"));
    }
}