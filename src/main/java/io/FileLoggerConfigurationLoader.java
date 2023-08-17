package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(String filePath) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
        inputStream.close();

        String filePathValue = properties.getProperty("filePath");
        long maxFileSizeValue = Long.parseLong(properties.getProperty("maxFileSize"));
        String fileFormatValue = properties.getProperty("fileFormat");
        LoggingLevel currentLogLevelValue = LoggingLevel.valueOf(properties.getProperty("currentLogLevel"));

        return new FileLoggerConfiguration(filePathValue, maxFileSizeValue, fileFormatValue, currentLogLevelValue);
    }
}
