package io;

public class FileLoggerConfiguration {
    private final String filePath;
    private final long maxFileSize;
    private final String fileFormat;
    private final LoggingLevel currentLogLevel;

    public FileLoggerConfiguration(String filePath, long maxFileSize, String fileFormat, LoggingLevel currentLogLevel) {
        this.filePath = filePath;
        this.maxFileSize = maxFileSize;
        this.fileFormat = fileFormat;
        this.currentLogLevel = currentLogLevel;
    }

    public String getFilePath() {
        return filePath;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public LoggingLevel getCurrentLogLevel() {
        return currentLogLevel;
    }

}
