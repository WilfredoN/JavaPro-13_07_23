package io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(String filePath) throws IOException {
        try (InputStream is = FileLoggerConfigurationLoader.class.getResourceAsStream(filePath)) {
            Properties properties = new Properties();
            properties.load(is);
            String path = properties.getProperty("path");
            String prefix = properties.getProperty("prefix");
            LoggingLevel level = LoggingLevel.valueOf(properties.getProperty("level"));
            long size = Long.parseLong(properties.getProperty("max-size"));
            return new FileLoggerConfiguration(path, size, prefix, level);
        }
    }
}
