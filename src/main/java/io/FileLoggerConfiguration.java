package io;

public class FileLoggerConfiguration {
    private String filePath;
    private long maxFileSize;
    private String fileFormat;
    private LoggingLevel currentLogLevel;

    public FileLoggerConfiguration(String filePath, long maxFileSize, String fileFormat, LoggingLevel currentLogLevel) {
        this.filePath = filePath;
        this.maxFileSize = maxFileSize;
        this.fileFormat = fileFormat;
        this.currentLogLevel = currentLogLevel;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getfileFormat() {
        return fileFormat;
    }

    public void setfileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public LoggingLevel getCurrentLogLevel() {
        return currentLogLevel;
    }

    public void setCurrentLogLevel(LoggingLevel currentLogLevel) {
        this.currentLogLevel = currentLogLevel;
    }
}
